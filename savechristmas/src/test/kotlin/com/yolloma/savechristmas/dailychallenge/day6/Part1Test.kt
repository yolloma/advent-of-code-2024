package com.yolloma.savechristmas.dailychallenge.day6

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part1Test {

    @Test
    fun testAll() {
        val floormap = arrayOf(
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#..."
        )
            .map { it.toCharArray() }
            .toTypedArray()

        assertEquals(41, Part1.execute(floormap))
    }


    @Test
    fun countDistinct() {
        val floormap = arrayOf(
            "....#.....",
            "#...XXXXXX",
            "....X.#..."
        )
            .map(String::toCharArray)
            .toTypedArray()

        assertEquals(7, floormap.countSteps())
    }

    @Test
    fun countSteps() {
        val path = "#...XXXXX".toCharArray()

        assertEquals(5, path.countSteps())
    }

    @Test
    fun findStart() {
        val floormap = arrayOf(
            "....#.....",
            "#.........",
            "....^.#..."
        ).map(String::toCharArray)
            .toTypedArray()


        assertEquals(2 to 4, floormap.findStartingPoint())
    }

    @Test
    fun getDirection() {
        val floormap = arrayOf(
            "....#.....",
            "#.........",
            "....^.#..."
        ).map(String::toCharArray)
            .toTypedArray()

        assertTrue(floormap.getStartingDirection(2 to 4).javaClass.isInstance(Up()))
    }

    @Test
    fun markSteps() {
        val floormap = arrayOf(
            "....#.....",
            "#.........",
            "....^.#..."
        ).map(String::toCharArray)
            .toTypedArray()

        val expected = arrayOf(
            "....#.....",
            "#...XXXXXX",
            "....X.#..."
        ).map(String::toCharArray)
            .toTypedArray()

        floormap.markSteps(2 to 4, Up())

        assertArrayEquals(expected, floormap)
    }
}
