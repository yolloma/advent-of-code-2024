package com.yolloma.savechristmas.dailychallenge.day2

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CountSafeReportsTest {

    @Test
    fun countSafeLevels(){
       val input =  listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
            listOf(1, 3, 2, 4, 5),
            listOf(8, 6, 4, 4, 1),
            listOf(1, 3, 6, 7, 9)
        )

        assertEquals(4, CountSafeReports.execute(input))
    }
}






