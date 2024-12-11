package com.yolloma.savechristmas.dailychallenge.day7

import com.yolloma.savechristmas.dailychallenge.day7.Part2.Tree
import com.yolloma.savechristmas.dailychallenge.day7.Part2.toTree
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part2Test {

    private val input = listOf(
        "190: 10 19", //10 * 19 = 190
        "3267: 81 40 27", //81 + 40 * 27 and 81 * 40 + 27
        "83: 17 5",
        "156: 15 6", //15 || 6
        "7290: 6 8 6 15", //6 * 8 || 6 * 15
        "161011: 16 10 13",
        "192: 17 8 14", //17 || 8 + 14
        "21037: 9 7 18 13",
        "292: 11 6 16 20" //11 + 6 * 16 + 20
    )

    @Test
    fun isSolved() {
        val actual = input.map(Part2::asCalibrationEquation).map(::toTree).map(Tree::isSolved)
        val expected = listOf(true, true, false, true, true, false, true, false, true)
        assertIterableEquals(expected, actual)
    }

    @Test
    fun sumSolvable() {
        val actual = Part2.execute(input)

        assertEquals(11387, actual)
    }
}