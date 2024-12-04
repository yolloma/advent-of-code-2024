package com.yolloma.savechristmas.dailychallenge.day4

object CountOccurrencesInWordsearch {

    private val directions = listOf(
        listOf(-1, 0),
        listOf(-1, 1),
        listOf(0, 1),
        listOf(1, 1),
        listOf(1, 0),
        listOf(1, -1),
        listOf(0, -1),
        listOf(-1, -1),
    )

    fun execute(input: Array<CharArray>): Int {
        var counter = 0

        for (i in input.indices) {
            for (j in input[0].indices) {

                if (input[i][j] == 'X') {
                    directions.forEach { dir ->
                        val xmas = checkDirection(input, dir, i, j)
                        if (xmas) counter++
                    }
                }

            }
        }

        return counter
    }

    private fun checkDirection(input: Array<CharArray>, dir: List<Int>, i: Int, j: Int): Boolean {
        val iDir = dir[0]
        val jDir = dir[1]

        if (!input.indices.contains(i + (iDir * 3)) || !input[0].indices.contains(j + (jDir * 3))) return false

        return input[i + iDir][j + jDir] == 'M' && input[i + 2 * iDir][j + 2 * jDir] == 'A' && input[i + 3 * iDir][j + 3 * jDir] == 'S'
    }

}