package com.yolloma.savechristmas.dailychallenge.day5

object FileParser {

    fun parseRules(input: List<String>): Map<Int, List<Int>> =
        input
            .map { rule -> rule.splitToInt("|").let { it.first() to it.last() } }
            .groupBy({ rule -> rule.first }, { rule -> rule.second })

    fun parseUpdates(input: List<String>): List<List<Int>> =
        input
            .map { update -> update.splitToInt(",") }

    private fun String.splitToInt(delim: String) = split(delim).map(String::toInt)
}