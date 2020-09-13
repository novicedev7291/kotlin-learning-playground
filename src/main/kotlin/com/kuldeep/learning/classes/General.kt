package com.kuldeep.learning.classes

class FullName(val first: String, val last: String) {
    init {
        println("Init block initialized before secondary constructor")
        val fullName = "$first $last"
    }

    constructor(name: String) : this(name.split(Regex(" "))[0], name.split(Regex(" "))[1]) {
        println("Secondary constructor body is called after init block")
    }
}


// Functional interface or SAM conversion
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearDiff = year - other.year
        val monthDiff = month - other.month
        return if(yearDiff == 0) {
            if(monthDiff == 0) {
                dayOfMonth - other.dayOfMonth
            } else monthDiff
        } else yearDiff

    }
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

// Override is used here because `start` will hide the super type `ClosedRange` start property
class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>

class Shop(val name:String){
    val orders: List<Product> by lazy {
        println("Products are being initialized now")
        ProductManager().loadProducts()
    }
}

class ProductManager() {
    fun loadProducts(): List<Product> {
        return listOf(Product("A", 389.09))
    }
}

fun main(args: Array<String>) {
    val fullName = FullName("Kuldeep Yadav")
    println("Firstname: ${fullName.first}")
    println("Lastname: ${fullName.last}")

    val isEven = IntPredicate { it % 2 == 0 }
    println("79302 is even? : ${isEven.accept(79302)}")

    val range = DateRange(MyDate(2019, 5,7), MyDate(2020, 8, 19))
    println(MyDate(2020, 6, 13) in range)

    val shop = Shop("Reliance E Store")
    println(shop.name)
    println(shop.name)
    println("******************")
    println(shop.orders)
}