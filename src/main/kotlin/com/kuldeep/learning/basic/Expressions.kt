package com.kuldeep.learning.basic

interface Vehicle {
    fun run()
}

fun main(args: Array<String>) {
    // If expression normal use
    var max = 10;
    val a = 11;
    val b = 100;

    if (a > b) max = a

    println(max)

    // If else
    if (a > b) {
        max = a
    } else {
        max = b
    }

    println(max)

    // IF else as ternary operator
    val century = if (max >= 100) true else false
    println("Reached Century? $century")

    // IF-ELSE branches as block
    val counter = 100
    val reset = if (counter >= 100) {
        println("Counter over")
        true
    } else {
        println("Counter has not reached yet")
        false
    }
    println("Is counter reset? $reset")


    // When expression instead of switch
    val animal = "Monkey"
    when (animal) {
        "Monkey" -> println("Animal is Monkey")
        "Lion" -> println("Animal is Lion")
        "Cat" -> println("Animal is Cat")
        else -> println("Unknown Animal")
    }

    //When block as assignment
    class Car : Vehicle {
        override fun run() {
            println("Running a car")
        }
    }

    class Truck : Vehicle {
        override fun run() {
            println("Running a truck")
        }
    }

    class Bike : Vehicle {
        override fun run() {
           println("Running a bike")
        }
    }

    val vehicle = "car"
    val aVehicle = when (vehicle) {
        "car" -> Car()
        "truck" -> Truck()
        else -> throw Error("Not a valid vehicle")
    }
    aVehicle.run()

    // in keyword inside when expression
    val x = 33
    when(x) {
        in 1..20 -> println("X is in lower range")
        in 20..50 -> println("X is in mid range")
    }

    // Type checking using when and is
    fun isValidInteger(x: Any) = when(x) {
        is Int, Long -> true
        else -> false
    }
    println(isValidInteger(12))
    println(isValidInteger("My name"))
    println(isValidInteger(Long.MAX_VALUE))

    // Type and startsWith string checking using when and !is, Bad example but I could not think of any
    // at the given moment
    fun isTwoWheeler(vehicle: Vehicle) = when(vehicle) {
        !is Bike -> false
        else -> true
    }
    println("Vehicle has 2 wheels only? ${isTwoWheeler(Car())}")
    println("Vehicle has 2 wheels only? ${isTwoWheeler(Bike())}")


}