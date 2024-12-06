package com.yolloma.savechristmas.dailychallenge.day6

import com.yolloma.savechristmas.dailychallenge.FileReader

object Day6Solver {

    fun execute() {
        val input = FileReader.readArray("day6_input.txt")

        Part1.execute(input)
            .also { println("Number of distinct positions: $it") }
    }
}

