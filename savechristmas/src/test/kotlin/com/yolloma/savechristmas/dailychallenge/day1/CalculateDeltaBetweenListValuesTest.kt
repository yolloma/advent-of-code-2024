package com.yolloma.savechristmas.dailychallenge.day1

import org.junit.jupiter.api.Assertions.*
import kotlin.math.abs
import kotlin.test.Test


class CalculateDeltaBetweenListValuesTest {

    @Test
    fun returnCorrectAmount() {
        val firstList = listOf(3, 4, 2, 1, 3, 3)
        val secondList = listOf(4, 3, 5, 3, 9, 3)

        assertEquals(11, CalculateDeltaBetweenListValues.execute(firstList, secondList))
    }

    @Test
    fun testSorted() {
        val unsorted = listOf(9, 3, 5, 3)
        val sorted = listOf(3, 3, 5, 9)

        assertIterableEquals(sorted, unsorted.sorted())
    }

    @Test
    fun testAbs() {
        val v1 = 3
        val v2 = 8
        val diff = 5

        assertEquals(diff, abs(v1 - v2))
    }
}
