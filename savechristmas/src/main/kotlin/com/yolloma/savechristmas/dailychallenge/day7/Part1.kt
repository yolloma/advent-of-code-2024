package com.yolloma.savechristmas.dailychallenge.day7

object Part1 {

    fun execute(input: List<String>): Long =
        input.map(::asCalibrationEquation)
            .map(::toTree)
            .filter(Tree::isSolved)
            .fold(0L) { acc, tree -> acc + tree.target }
}

fun asCalibrationEquation(s: String) =
    s.split(":")
        .let {
            Calibration(
                result = it.first().toLong(),
                testValues = it.last().trim().split(" ").map(String::toLong)
            )
        }


fun toTree(calibration: Calibration): Tree =
    Tree(calibration.result)
        .apply { calibration.testValues.forEach(this::next) }

data class Calibration(val result: Long, val testValues: List<Long>)

class Node(val total: Long) {

    fun addChildren(nextVal: Long): List<Node> =
        listOf(
            Node(total = total * nextVal),
            Node(total = total + nextVal),
        )
}

 class Tree(val target: Long) {

    private var leaves: List<Node> = emptyList()

    fun next(value: Long) {
        leaves =
            if (leaves.isEmpty()) listOf(Node(value))
            else leaves.map { it.addChildren(value) }.flatten().filterNot { it.total > target }
    }

    fun isSolved() = leaves.any { it.total == target }
}
