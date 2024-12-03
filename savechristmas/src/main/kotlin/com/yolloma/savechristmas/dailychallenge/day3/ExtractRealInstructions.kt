package com.yolloma.savechristmas.dailychallenge.day3

object ExtractRealInstructions {

    private const val MUL_PTRN = "(mul\\([0-9]{1,3},[0-9]{1,3}\\))"
    private const val ENBLD_PTRN = "do\\(\\)"
    private const val DISBLD_PTRN = "don't\\(\\)"

    private val instructionRegex = Regex("$MUL_PTRN|$DISBLD_PTRN|$ENBLD_PTRN")

    fun execute(input: String): List<String> =
        instructionRegex.findAll(input)
            .map(MatchResult::value)
            .toList()
}

