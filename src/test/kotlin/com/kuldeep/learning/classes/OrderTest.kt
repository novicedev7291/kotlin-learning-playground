package com.kuldeep.learning.classes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

internal class OrderTest {
    @Test fun `Two orders must be equals with same properties`() {
        val p1 = Product("P1", 21.97)
        val p2 = Product("P2", 24.42)
        val orderLines = listOf(OrderLine(p1, 2, ), OrderLine(p2, 5))

        val o1 = Order("Kuldeep", 239.89, orderLines)
        val o2 = Order("Kuldeep", 239.89, orderLines)

        assertThat(o1, equalTo(o2))
    }
}