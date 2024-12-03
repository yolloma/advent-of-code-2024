package com.yolloma.savechristmas.dailychallenge.day1

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculateSimilarityScoreBetweenListsTest {

    @Test
    fun similarityScoreIsCorrect(){
        val firstList = listOf(3, 4, 2)
        val secondList = listOf(4, 3, 5)

        val expected = 7 // 3*1 + 4*1

        assertEquals(expected, CalculateSimilarityScoreBetweenLists.execute(firstList, secondList))
    }

}