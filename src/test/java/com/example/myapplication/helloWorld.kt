package com.example.myapplication

import org.junit.Test

class helloWorld {
    @Test
    fun main() {
        println("What's your name?")
        val name = readln()
        println("Hello, $name!")

    }
}