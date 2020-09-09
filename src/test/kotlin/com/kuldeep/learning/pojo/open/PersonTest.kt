package com.kuldeep.learning.pojo.open

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test fun `Person must have all properties set`() {
        val p = Person("kuldeep", "yadav", 38, "kuldeepyadav7291@gmail.com")

        assertThat(p.firstName, equalTo("kuldeep"))
        assertThat(p.lastName, equalTo("yadav"))
        assertThat(p.age, equalTo(38))
        assertThat(p.email, equalTo("kuldeepyadav7291@gmail.com"))
    }

    @Test fun `Two person object must be equal after implementing equals and hash in open`() {
       val p1 = Person("kuldeep", "yadav", 38, "kuldeepyadav7291@gmail.com")
       val p2 = Person("kuldeep", "yadav", 38, "kuldeepyadav7291@gmail.com")

        assertThat(p1, equalTo(p2))
    }
}