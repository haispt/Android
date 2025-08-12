package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        println("Hello, World!")

        var a:String = "Biến kiểu String" //1
        println(a)

        val b: Int = 2
        println(b)

        val c = 3 //Không cần kiểu dữ liệu
        println(c)



    }

}