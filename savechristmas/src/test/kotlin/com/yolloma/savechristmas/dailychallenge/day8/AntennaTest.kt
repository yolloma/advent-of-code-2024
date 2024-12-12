package com.yolloma.savechristmas.dailychallenge.day8

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class AntennaTest {

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
    fun shouldGetAntenna() {
        val antenna0 = listOf(
            Antenna(1, 8, '0'),
            Antenna(2, 5, '0'),
            Antenna(3, 7, '0'),
            Antenna(4, 4, '0')
        )

        val antennaA = listOf(
            Antenna(5, 6, 'A'),
            Antenna(8, 8, 'A'),
            Antenna(9, 9, 'A')
        )

        val expected = mapOf(
            '0' to antenna0,
            'A' to antennaA
        )

        assertIterableEquals(expected['0'], input.getAntennae()['0'])
        assertIterableEquals(expected['A'], input.getAntennae()['A'])
    }

    @Test
    fun shouldFindAllAntinodesForAntenna() {
        val antennaA = listOf(
            Antenna(5, 6, 'A'),
            Antenna(8, 8, 'A'),
            Antenna(9, 9, 'A')
        )

        val expected = listOf(
            Point(11, 10),
            Point(2, 4),
            Point(1, 3),
            Point(10, 10),
            Point(7,7)
        )

        assertIterableEquals(expected, antennaA.findAllAntinodes(input.iRange, input.jRange, Part1::findAntinodes))
    }
}
