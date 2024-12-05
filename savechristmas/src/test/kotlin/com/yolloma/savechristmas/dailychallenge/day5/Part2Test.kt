package com.yolloma.savechristmas.dailychallenge.day5

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Part2Test {

    private val rules = mapOf(
        97 to listOf(13, 61, 47, 29, 53, 75),
        75 to listOf(29, 53, 47, 61, 13),
        61 to listOf(13, 53, 29),
        53 to listOf(29, 13),
        47 to listOf(53, 13, 61, 29),
        29 to listOf(13)
    )

    @Test
    fun findIncorrectUpdates() {
        val updates = listOf(
            listOf(75, 47, 61, 53, 29),
            listOf(97, 61, 53, 29, 13),
            listOf(75, 29, 13),
            listOf(75, 97, 47, 61, 53),
            listOf(61, 13, 29),
            listOf(97, 13, 75, 29, 47)
        )

        assertEquals(updates.subList(3, 6), Part2(rules).findIncorrectUpdates(updates))
    }

    @Test
    fun sorting() {
        val incorrect = listOf(97, 13, 75, 29, 47)

        assertIterableEquals(listOf(97, 75, 47, 29, 13), Part2(rules).order(incorrect))
    }
}
