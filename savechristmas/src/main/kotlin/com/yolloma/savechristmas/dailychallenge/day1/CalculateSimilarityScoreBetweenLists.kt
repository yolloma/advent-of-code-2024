package com.yolloma.savechristmas.dailychallenge.day1

object CalculateSimilarityScoreBetweenLists {

    fun execute(list1: List<Int>, list2: List<Int>): Int {
        val occurences = list2.groupingBy { it }.eachCount()
        var simScore = 0

        list1.forEach { v ->
            simScore += v * occurences.getOrDefault(v, 0)
        }

        return simScore
    }
}