package com.yolloma.savechristmas.dailychallenge.day8

import com.yolloma.savechristmas.dailychallenge.FileReader
import kotlin.time.measureTimedValue

object Day8Solver {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = FileReader.readLines("day8_input.txt")

        measureTimedValue {
            Part2.execute(input)
        }.let {
            println("Number of antinodes: ${it.value}")
            println("Time elapsed: ${it.duration}")
        }
    }
}
