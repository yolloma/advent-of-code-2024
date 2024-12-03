package com.yolloma.savechristmas.dailychallenge.day3

object ExecuteValidInstructions {

    private val intRegex = Regex("[0-9]{1,3}")

    fun execute(input: List<String>): Int {
        var enabled = true
        var sum = 0

        input.forEach { inst ->
            if (inst == "don't()") {
                enabled = false
                return@forEach
            }

            if (inst == "do()") {
                enabled = true
                return@forEach
            }

            if(enabled){
                sum += evaluateMultiplyInstruction(inst)
            }
        }

        return sum
    }

    private fun evaluateMultiplyInstruction(input: String): Int =
        intRegex.findAll(input)
            .map(MatchResult::value)
            .map(String::toInt)
            .reduce { v1, v2 -> v1 * v2 }
}