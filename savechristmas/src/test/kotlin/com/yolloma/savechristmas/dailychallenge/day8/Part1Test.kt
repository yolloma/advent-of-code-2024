package com.yolloma.savechristmas.dailychallenge.day8

import com.yolloma.savechristmas.dailychallenge.day8.Part1.findAntinodes
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part1Test {

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
        assertEquals(14, Part1.execute(input))
    }

    @Test
    fun shouldFindAntinodes() {
        val antenna0 = listOf(
            Antenna(1, 8, '0'),
            Antenna(2, 5, '0')
        )

        val expected = listOf(
            Point(3, 2),
            Point(0, 11)
        )

        assertIterableEquals(expected, findAntinodes(antenna0[0], antenna0[1], input.iRange, input.jRange ))
    }
}