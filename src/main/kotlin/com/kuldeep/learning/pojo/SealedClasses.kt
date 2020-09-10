package com.kuldeep.learning.pojo

sealed class Planet {
    sealed class Earth: Planet()
    sealed class Mars: Planet()
    sealed class Jupiter: Planet()
    sealed class Neptune: Planet()
}