package com.yolloma.savechristmas.dailychallenge.day5

class Part1(private val rules: Map<Int, List<Int>>) {

    fun execute(updates: List<List<Int>>): Int =
        findCorrectUpdates(updates)
            .let(::sumMiddleElements)

    fun findCorrectUpdates(updates: List<List<Int>>): List<List<Int>> =
        updates.filter { update -> isCorrect(update, rules) }
}

class Part2(private val rules: Map<Int, List<Int>>) {

    fun execute(updates: List<List<Int>>): Int =
        findIncorrectUpdates(updates)
            .map(::order)
            .let(::sumMiddleElements)

    fun findIncorrectUpdates(updates: List<List<Int>>): List<List<Int>> =
        updates.filter { update -> !isCorrect(update, rules) }

    fun order(list: List<Int>) =
        list.sortedWith { o1, o2 ->
            if (this.rules.getOrDefault(o2, emptyList()).contains(o1)) 1 else -1
        }
}

fun isCorrect(list: List<Int>, rules: Map<Int, List<Int>>): Boolean {
    list.forEachIndexed { index, i ->
        val rule = rules.getOrDefault(i, emptyList())

        if (list.subList(0, index).any(rule::contains)) return false
    }
    return true
}

fun sumMiddleElements(updates: List<List<Int>>): Int =
    updates.fold(0) { sum, update -> sum + update.extractMiddleElement() }

private fun List<Int>.extractMiddleElement(): Int =
    get(indices.last / 2)
