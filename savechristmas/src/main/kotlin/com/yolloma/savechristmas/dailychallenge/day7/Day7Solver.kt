package com.yolloma.savechristmas.dailychallenge.day7

import com.yolloma.savechristmas.dailychallenge.FileReader
import kotlin.time.measureTimedValue

object Day7Solver {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = FileReader.readLines("day7_input.txt")

        measureTimedValue {
            Part1.execute(input)
        }.let {
            println("Total solvable: $it")
            println("Time elapsed: ${it.duration} secs")
        }
    }
}

