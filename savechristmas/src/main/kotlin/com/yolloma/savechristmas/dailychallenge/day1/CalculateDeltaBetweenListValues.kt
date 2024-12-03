package com.yolloma.savechristmas.dailychallenge.day1

import kotlin.math.abs

object CalculateDeltaBetweenListValues {

    fun execute(list1: List<Int>, list2: List<Int>): Int {
        return list1.sorted()
            .zip(list2.sorted()) { v1, v2 ->
                abs(v1 - v2)
            }
            .reduce { acc, i -> acc + i }
    }
}

