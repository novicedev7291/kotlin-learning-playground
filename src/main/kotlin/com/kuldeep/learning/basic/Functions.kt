package com.kuldeep.learning.basic

// Any default parameter
fun makePizza(size: String = "Medium", toppings: String) {
    println("Creating $size pizza with toppings $toppings")
}

// Function with lambda as last param
fun fetchMapLocation(lat: Int, long: Int, callback: (response: String) -> Unit) {
    println("Calling google service with $lat and $long")
    callback("""{"status": "success", "location": {"lat":$lat, "long": $long} }""")
}

fun main(array: Array<String>) {
    //Default size must be medium in this case
    makePizza(toppings = "Tomato, Onion")

    //Overriding default size
    makePizza(size = "large", toppings = "onion, capsicum, red peprika")

    // Ways to call a function which has lambda fun as last parameter
    fetchMapLocation(20,30) { println(it) }
    fetchMapLocation(10, 219, callback = { println(it) })

    // function body as expression
    fun add(x: Int, y: Int): Int = x + y
    println("Sum of 10 + 20 : ${add(10, 20)}")

    // varargs
    fun convertToUpperCase(vararg names: String): List<String> {
        return names.map { it.toUpperCase() }
    }
    println(convertToUpperCase("kuldeep", "sandeep"))

    /**
     * Infix function, calling function with just name omitting . and param, with conditions
     * - must be member functions or extension function
     * - must have only single parameter
     * - parameter must not be of vararg type and have no default value
     */
    infix fun String.startsWith(aChar: Char):Boolean = this.indexOfFirst { it == aChar } == 0
    println("Monkey starts with M? ${"Monkey" startsWith 'M'}")

    // If extension function has same return type, same param type and same name
    // Then member function will win
    class SomeClass {
        fun functionWithSomeName() {
            println("Member function wins")
        }
    }
    fun SomeClass.functionWithSomeName() = println("Extension function wins")
    SomeClass().functionWithSomeName()

    // But we can overload the extension method
    fun SomeClass.functionWithSomeName(param: String) = println("Extension method is called with $param")
    SomeClass().functionWithSomeName("Testing")
}