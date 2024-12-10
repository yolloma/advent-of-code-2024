package com.yolloma.savechristmas.dailychallenge.day6

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part2Test {

    private val floormap: List<String> = listOf(
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

    val obstacles = listOf(
        Pos(0,4),
        Pos(1,9),
        Pos(3, 2),
        Pos(4, 7),
        Pos(6, 1),
        Pos(7, 8),
        Pos(8, 0),
        Pos(9, 6),
    )

    @Test
    fun shouldWork() {
        assertEquals(6, Part2.execute(floormap))
    }

    @Test
    fun getStart() {
        assertEquals(Pos(6, 4), floormap.findInitialPos())
    }

    @Test
    fun recordCorrectNumOfSteps() {
        val uniquePositions = floormap
            .recordSteps(Step(Pos(6, 4), Dir.UP), obstacles)
            .map(Step::pos)
            .toSet().size

        assertEquals(41, uniquePositions)
    }

    @Test
    fun getObstaclePositions() {
        val actual = floormap.getAllObstaclePositions()

        assertIterableEquals(obstacles, actual)
    }
}