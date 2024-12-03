package com.yolloma.savechristmas.dailychallenge.day2

import kotlin.math.abs

object CheckReportIsSafe {

    fun execute(list: List<Int>): Boolean {
        return checkIsSafe(list)
    }

    private fun checkIsSafe(list: List<Int>, isDampened: Boolean = false): Boolean {
        val shouldIncrease = isIncreasing(list)

        list.forEachIndexed { index, curr ->
            if (index == 0) return@forEachIndexed

            val prev = list[index - 1]

            val isSafe = isSafe(shouldIncrease, curr, prev)

            if (!isSafe && !isDampened) {
                val checkWithoutPrevious = checkIsSafe(list.removeIndexFromList(index - 1), true)
                val checkWithoutCurrent = checkIsSafe(list.removeIndexFromList(index), true)

                return checkWithoutPrevious || checkWithoutCurrent
            }

            if (!isSafe) return false
        }

        return true
    }

    private fun isSafe(shouldIncrease: Boolean, curr: Int, prev: Int): Boolean {
        if (prev == curr) return false

        val isIncreasing = prev < curr
        val delta = abs(curr - prev)
        return (isIncreasing == shouldIncrease) && (delta in 1..3)
    }

    private fun isIncreasing(list: List<Int>): Boolean {
        var incs = 0
        var decs = 0

        list.forEachIndexed { index, curr ->
            if (index == 0) return@forEachIndexed

            val prev = list[index - 1]

            if (prev < curr) incs++
            if (prev > curr) decs++
        }

        return incs > decs
    }
}

private fun List<Int>.removeIndexFromList(index: Int): List<Int> {
    val sublist = toMutableList()
    sublist.removeAt(index)
    return sublist
}
