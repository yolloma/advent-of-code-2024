package com.yolloma.savechristmas.dailychallenge.day2

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CheckReportIsSafeTest {

    @Test
    fun reportIsSafe() {
        listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 3, 6, 7, 9)
        )
            .forEach { assertTrue(CheckReportIsSafe.execute(it)) }
    }

    @Test
    fun reportIsNotSafe() {
        listOf(
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
        )
            .forEach { assertFalse(CheckReportIsSafe.execute(it)) }
    }

    @Test
    fun reportIsSafeWithProblemDampener() {
        listOf(
            listOf(1, 3, 2, 4, 5),
            listOf(8, 6, 4, 4, 1),
            listOf(48, 48, 50, 53, 55, 57)
        )
            .forEach { assertTrue(CheckReportIsSafe.execute(it)) }
    }

    @Test
    fun returnAtForEach() {
        (1..4).forEach { i ->
            if (i == 3) return@forEach
            println(i)
        }
    }
}
