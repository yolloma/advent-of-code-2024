package com.yolloma.savechristmas.dailychallenge.day3

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ExecuteValidInstructionsTest {

    @Test
    fun returnCorrectResult() {
        val input = listOf("mul(2,4)", "don't()", "mul(5,5)", "mul(11,8)", "do()", "mul(8,5)")

        val expected = (2 * 4) + (8 * 5) //= 48

        assertEquals(expected, ExecuteValidInstructions.execute(input))
    }
}