package com.kuldeep.learning.classes

import com.fasterxml.jackson.databind.ObjectMapper
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.contains
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import kotlin.test.assertFails

internal class PersonTest {
    @Test fun `Person must have all properties set`() {
        val p = Person("kuldeep", "yadav", 38, "kuldeepyadav7291@gmail.com")

        assertThat(p.age, equalTo(38))
        assertThat(p.email, equalTo("kuldeepyadav7291@gmail.com"))
    }

    @Test fun `Two person object must be equal after implementing equals and hash in open`() {
       val p1 = Person("kuldeep", "yadav", 38, "kuldeepyadav7291@gmail.com")
       val p2 = Person("kuldeep", "yadav", 38, "kuldeepyadav7291@gmail.com")

        assertThat(p1, equalTo(p2))
    }

    @Test fun `Full name property have correct name`() {
        val person = Person("Kuldeep", "Yadav", 38, "kuldeep@abc.com")

        assertThat(person.name , equalTo("Kuldeep Yadav"))
    }

    @Test fun `Must create json from given object`() {
        val person = Person("Kavita", "Krishnamurthy", 68, "kavita@abc.com")
        val actual = ObjectMapper().writeValueAsString(person)
        assertThat(actual, contains(Regex("name")))
    }

    @Test fun `Fail to create object back from json`() {
        val json = """{"name":"Sandeep Yadav", "age": 23, "email": "sandeep@abc.com"}"""
        assertFails { ObjectMapper().convertValue(json, Person::class.java) }
    }
}