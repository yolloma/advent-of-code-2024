package com.yolloma.savechristmas.dailychallenge.day7

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part1Test {

    private val input = listOf(
        "190: 10 19", //10 * 19 = 190
        "3267: 81 40 27", //81 + 40 * 27 and 81 * 40 + 27
        "83: 17 5",
        "156: 15 6",
        "7290: 6 8 6 15",
        "161011: 16 10 13",
        "192: 17 8 14",
        "21037: 9 7 18 13",
        "292: 11 6 16 20" //11 + 6 * 16 + 20
    )

    @Test
    fun splitString() {
        assertEquals(Calibration(190, listOf(10, 19)), asCalibrationEquation("190: 10 19"))
        assertEquals(Calibration(7290, listOf(6, 8, 6, 15)), asCalibrationEquation("7290: 6 8 6 15"))
    }
}