package com.yolloma.savechristmas.dailychallenge.day4

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CountOccurrencesInWordsearchTest {

    @Test
    fun solveWordsearch() {
        val input = arrayOf(
            charArrayOf('.', '.', 'X', '.', '.', '.'),
            charArrayOf('.', 'S', 'A', 'M', 'X', '.'),
            charArrayOf('.', 'A', '.', '.', 'A', '.'),
            charArrayOf('X', 'M', 'A', 'S', '.', 'S'),
            charArrayOf('.', 'X', '.', '.', '.', '.')
        )

        assertEquals(0, CountOccurrencesInWordsearch.execute(input))
    }

    @Test
    fun solveWordsearchAgain() {
        val input = listOf(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        )
            .map { it.toCharArray() }
            .toTypedArray()

        assertEquals(9, CountOccurrencesInWordsearch.execute(input))
    }
}