package com.yolloma.savechristmas.dailychallenge.day4

import com.yolloma.savechristmas.dailychallenge.FileReader

object Day4Solver {

    fun execute() {
        val input = FileReader.readArray("day4_input.txt")

        CountOccurrencesInWordsearch.execute(input)
            .also { println("XMAS count in wordsearch: $it")}

    }
}


