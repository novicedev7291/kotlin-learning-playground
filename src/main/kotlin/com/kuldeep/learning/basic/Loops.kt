package com.kuldeep.learning.basic

fun main(args: Array<String>) {
    // Traditional for loop
    for(i: Int in 0..9) {
        println("Iteration : $i")
    }

    // for-each loop over collection
    // Collection or structure must have function or extension function iterator(), whose return type
    //  must have next() function or extension function
    // must have hasNext() function or extension function
    val names = listOf("Kuldeep", "Reena" , "sandeep")
    for(name in names) {
        println(name)
    }

    // Stepping on range
    for(i:Int in 9 downTo 0 step 3) {
        println("Step : $i")
    }

    // looping on indices of an array
    val months: Array<String> = arrayOf("jan", "feb", "mar", "dec")
    for(i in months.indices) {
        println(months[i])
    }

    // While and do-while are same as their counterpart in java
    var x = 10;
    while(x > 0) {
        println("Reducing x : ${x--}")
    }
}