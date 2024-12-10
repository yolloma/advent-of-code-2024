package com.yolloma.savechristmas.dailychallenge.day6

import com.yolloma.savechristmas.dailychallenge.FileReader
import kotlin.time.measureTimedValue

object Day6Solver {

    fun execute() {
        val input = FileReader.readLines("day6_input.txt")

//        Part1.execute(input)
//            .also { println("Number of distinct positions: $it") }

        measureTimedValue {
            Part2.execute(input)
        }.let {
            println("Number of possible loops: ${it.value}")
            println("Time elapsed: ${it.duration} secs") }
    }
}

