package com.yolloma.savechristmas.dailychallenge.day5

import com.yolloma.savechristmas.dailychallenge.FileReader

object Day5Solver {

    fun execute() {
        val updatesInput = FileReader.readLines("day5_2_input.txt")
            .let(FileParser::parseUpdates)

        val rulesInput = FileReader.readLines("day5_1_input.txt")
            .let(FileParser::parseRules)

        Part1(rulesInput).execute(updatesInput)
            .also { println("Sum of middle pages: $it") }

        Part2(rulesInput).execute(updatesInput)
            .also { println("Sum of corrected middle pages: $it") }
    }
}

