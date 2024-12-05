package com.yolloma.savechristmas.dailychallenge.day5

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part1Test {

    @Test
    fun findCorrectUpdates() {
        val updates = listOf(
            listOf(75, 47, 61, 53, 29),
            listOf(97, 61, 53, 29, 13),
            listOf(75, 29, 13),
            listOf(75, 97, 47, 61, 53),
            listOf(61, 13, 29),
            listOf(97, 13, 75, 29, 47)
        )

        val rules = mapOf(
            97 to listOf(13, 61, 47, 29, 53, 75),
            75 to listOf(29, 53, 47, 61, 13),
            61 to listOf(13, 53, 29),
            53 to listOf(29, 13),
            47 to listOf(53, 13, 61, 29),
            29 to listOf(13)
        )

        assertEquals(updates.subList(0,3), Part1(rules).findCorrectUpdates(updates))
    }

    @Test
    fun sumMiddlePages() {
        val updates = listOf(
            listOf(75, 47, 61, 53, 29),
            listOf(97, 61, 53, 29, 13),
            listOf(75, 29, 13)
        )

        assertEquals(143, sumMiddleElements(updates))
    }
}
