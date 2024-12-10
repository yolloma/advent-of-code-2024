package com.yolloma.savechristmas.dailychallenge.day6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger

object Part2 {

    fun execute(input: List<String>): Int {
        val start = Step(input.findInitialPos(), Dir.UP)
        val obstacles = input.getAllObstaclePositions()

        val stepPath = input.recordSteps(start, obstacles)

        val loops = AtomicInteger(0)

        runBlocking(Dispatchers.Default) {
            stepPath.map(Step::pos).toSet()
                .forEach { pos ->
                    launch {
                        if (input.isLooped(start, obstacles.plus(pos))) loops.incrementAndGet()
                    }
                }
        }

        return loops.get()
    }
}

data class Pos(val i: Int, val j: Int)
enum class Dir(val iInc: Int, val jInc: Int) {
    UP(-1, 0),
    DOWN(1, 0),
    RIGHT(0, 1),
    LEFT(0, -1);

    fun turn(): Dir =
        when (this) {
            UP -> RIGHT
            RIGHT -> DOWN
            DOWN -> LEFT
            LEFT -> UP
        }
}

data class Step(val pos: Pos, val dir: Dir) {
    fun next(): Step = this.copy(pos = Pos(pos.i + dir.iInc, pos.j + dir.jInc))
    fun turn(): Step = this.copy(dir = dir.turn())
}


fun List<String>.recordSteps(first: Step, obstacles: List<Pos>): List<Step> {
    val stepRecord = mutableListOf(first)
    var step = first

    while (isInBounds(step.next().pos)) {
        if (obstacles.contains(step.next().pos)) {
            step = step.turn()
            continue
        }

        step = step.next().also(stepRecord::add)
    }

    return stepRecord
}


fun List<String>.isLooped(first: Step, obstacles: List<Pos>): Boolean {
    val stepRecord = mutableListOf(first)
    var step = first

    while (isInBounds(step.next().pos)) {
        if (stepRecord.contains(step.next())) return true

        if (obstacles.contains(step.next().pos)) {
            step = step.turn()
            continue
        }

        step = step.next().also(stepRecord::add)
    }

    return false
}

fun List<String>.isInBounds(pos: Pos) =
    pos.i in this.indices && pos.j in this[0].indices

fun List<String>.getAllObstaclePositions() =
    mapIndexed { i, chars ->
        chars.mapIndexed { j, c -> if (c == '#') Pos(i, j) else null }
    }.flatten().filterNotNull()

fun List<String>.findInitialPos(): Pos =
    indexOfFirst { chars -> chars.contains('^') }
        .let { i -> Pos(i, this[i].indexOfFirst { char -> char == '^' }) }
