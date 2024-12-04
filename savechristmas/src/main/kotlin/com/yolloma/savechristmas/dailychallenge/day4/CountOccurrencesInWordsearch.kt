package com.yolloma.savechristmas.dailychallenge.day4

object CountOccurrencesInWordsearch {

    fun execute(input: Array<CharArray>): Int {
        var counter = 0

        for (i in input.indices) {
            for (j in input[0].indices) {

                if (input[i][j] == 'A') {
                    val xmas = checkDirection(input, i, j)
                    if (xmas) counter++
                }
            }
        }

        return counter
    }

    private fun checkDirection(input: Array<CharArray>, i: Int, j: Int): Boolean {
        if (i == 0 || i == input.indices.max() || j == 0 || j == input[0].indices.max()) return false

        val iDir1 = -1
        val jDir1 = 1

        val iDir2 = -1
        val jDir2 = -1

        return listOf(input[i + iDir1][j + jDir1], input[i - iDir1][j - jDir1]).containsAll(listOf('M', 'S')) &&
                listOf(input[i + iDir2][j + jDir2], input[i - iDir2][j - jDir2]).containsAll(listOf('M', 'S'))
    }

}
