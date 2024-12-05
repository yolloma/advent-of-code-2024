package com.yolloma.savechristmas.dailychallenge.day5

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class FileParserTest {

    @Test
    fun ruleParser() {
        val rule_input = listOf(
            "47|53",
            "97|13",
            "97|61",
            "97|47",
            "75|29",
            "61|13",
            "75|53",
            "29|13",
            "97|29",
            "53|29",
            "61|53",
            "97|53",
            "61|29",
            "47|13",
            "75|47",
            "97|75",
            "47|61",
            "75|61",
            "47|29",
            "75|13",
            "53|13"
        )

        val expected = mapOf(
            97 to listOf(13, 61, 47, 29, 53, 75),
            75 to listOf(29, 53, 47, 61, 13),
            61 to listOf(13, 53, 29),
            53 to listOf(29, 13),
            47 to listOf(53, 13, 61, 29),
            29 to listOf(13)
        )

        val actual = FileParser.parseRules(rule_input)
        expected.forEach { (key, value) ->
            assertTrue { value.containsAll(actual.getValue(key)) }
        }
    }
}