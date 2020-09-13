package com.kuldeep.learning.classes

data class Product(val code: String, val price: Double)

data class OrderLine(val product: Product, val qty: Int)

data class Order(val customer: String, val total: Double, val orderLines: List<OrderLine>)