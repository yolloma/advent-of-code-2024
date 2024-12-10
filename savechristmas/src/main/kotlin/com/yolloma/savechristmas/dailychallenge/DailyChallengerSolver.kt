package com.yolloma.savechristmas.dailychallenge

import com.yolloma.savechristmas.dailychallenge.day6.Day6Solver
import kotlin.time.measureTime

object DailyChallengerSolver {

    @JvmStatic
    fun main(args: Array<String>) {
        measureTime {
            Day6Solver.execute()
        }.let(::println)
    }
}
