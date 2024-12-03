package com.yolloma.savechristmas.dailychallenge.day1

import com.yolloma.savechristmas.dailychallenge.FileReader

object Day1Solver {

    fun execute(input: String) {
        val (list1, list2) = FileReader.readIntLists("day1_input.txt")

        CalculateDeltaBetweenListValues.execute(list1, list2)
            .also { println("Total distance: $it") }

        CalculateSimilarityScoreBetweenLists.execute(list1, list2)
            .also { println("Similarity score: $it") }
    }

}