package com.yolloma.savechristmas.dailychallenge.day3

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ExtractRealInstructionsTest {

    @Test
    fun extractValidInstructions() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        //matches: mul(2,4) don't() mul(5,5) mul(11,8) do() mul(8,5)
        val expected = listOf(
            "mul(2,4)",
            "don't()",
            "mul(5,5)",
            "mul(11,8)",
            "do()",
            "mul(8,5)"
        )

        assertEquals(expected, ExtractRealInstructions.execute(input))
    }
}
