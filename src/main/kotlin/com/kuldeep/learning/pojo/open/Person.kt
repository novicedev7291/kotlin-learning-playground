package com.kuldeep.learning.pojo.open

class Person(val firstName:String, val lastName:String, val age:Int, val email: String) {
    override fun equals(other: Any?): Boolean = other is Person
            && firstName == other.firstName
            && lastName == other.lastName
            && age == other.age
            && email == other.email

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + age
        result = 31 * result + email.hashCode()
        return result
    }
}