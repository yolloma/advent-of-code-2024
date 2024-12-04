package com.yolloma.savechristmas.dailychallenge

import org.junit.jupiter.api.Assertions.*
import java.io.File
import kotlin.test.Test
import kotlin.test.assertFails

class FileReaderTest {

    private val fileReader = FileReader

    @Test
    fun readTheFileWithPath() {
        assertFails { File("filereader_lists_test.txt").readText() }
    }

    @Test
    fun readTheFileWithClassLoader() {
        ClassLoader.getSystemResource("filereader_lists_test.txt").readText()
    }

    @Test
    fun readLists() {
        val expected = listOf(
            listOf(15131, 32438, 12503, 73808, 57168),
            listOf(78158, 35057, 57702, 43128, 71761)
        )

        val actual = fileReader.readIntLists("filereader_lists_test.txt")

        assertIterableEquals(actual.first, expected.first())
        assertIterableEquals(actual.second, expected.last())
    }

    @Test
    fun readReports() {
        val expected = listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
            listOf(1, 3, 2, 4, 5)
        )

        val actual = fileReader.readReportLevels("filereader_reports_test.txt")

        assertIterableEquals(actual[0], expected.first())
        assertIterableEquals(actual[3], expected.last())
    }

    @Test
    fun readArray() {
        val expected = arrayOf(
            charArrayOf('.', '.', 'X', '.', '.', '.'),
            charArrayOf('.', 'S', 'A', 'M', 'X', '.'),
            charArrayOf('.', 'A', '.', '.', 'A', '.'),
            charArrayOf('X', 'M', 'A', 'S', '.', 'S'),
            charArrayOf('.', 'X', '.', '.', '.', '.')
        )

        val actual = fileReader.readArray("filereader_array_test.txt")

        assertArrayEquals(actual.first(), expected.first())
        assertArrayEquals(actual[3], expected[3])
    }
}

