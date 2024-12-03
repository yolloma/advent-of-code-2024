package com.yolloma.savechristmas.dailychallenge.day3

import com.yolloma.savechristmas.dailychallenge.FileReader

object Day3Solver {

    fun execute(){
        val input = FileReader.readString("day3_input.txt")

        val instructions = ExtractRealInstructions.execute(input)
            .also { println("Valid instructions: $it")}

        ExecuteValidInstructions.execute(instructions)
            .also { println("Enabled multiplication instructions: $it")}
    }
}