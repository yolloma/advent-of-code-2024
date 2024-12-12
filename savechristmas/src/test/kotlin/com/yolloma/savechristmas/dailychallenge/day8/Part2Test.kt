package com.yolloma.savechristmas.dailychallenge.day8

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part2Test {
    private val input = listOf(
        "............",
        "........0...",
        ".....0......",
        ".......0....",
        "....0.......",
        "......A.....",
        "............",
        "............",
        "........A...",
        ".........A..",
        "............",
        "............"
    )

    @Test
    fun shouldReturnCorrectAnswer(){
        assertEquals(34, Part2.execute(input))
    }

    @Test
    fun shouldReturnCorrectAnswerAgain(){
        val foo = listOf(
            "T.........",
            "...T......",
            ".T........",
            "..........",
            "..........",
            "..........",
            "..........",
            "..........",
            "..........",
            ".........."
        )
        assertEquals(9, Part2.execute(foo))
    }
}