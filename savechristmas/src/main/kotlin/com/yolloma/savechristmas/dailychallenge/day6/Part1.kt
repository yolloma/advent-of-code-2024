package com.yolloma.savechristmas.dailychallenge.day6

object Part1 {

    fun execute(input: Array<CharArray>): Int {
        val startAt = input.findStartingPoint()
        val direction = input.getStartingDirection(startAt)

        input.markSteps(startAt, direction)

        return input.countSteps()
    }
}

fun Array<CharArray>.markSteps(startAt: Pair<Int, Int>, direction: Direction) {
    setX(startAt)

    var ind = startAt
    var dir = direction

    while (isInBounds(ind.first + dir.iInc, ind.second + dir.jInc)) {
        if(isObstruction(ind.first + dir.iInc, ind.second + dir.jInc)){
            dir = dir.next
            continue
        }

        ind = (ind.first + dir.iInc) to (ind.second + dir.jInc)

        setX(ind)
    }
}

fun Array<CharArray>.isInBounds(i: Int, j: Int) =
    i <= this.lastIndex && j <= this[0].lastIndex

fun Array<CharArray>.isObstruction(i: Int, j: Int) =
    this[i][j] == '#'

fun Array<CharArray>.setX(ind: Pair<Int, Int>) =
    this[ind.first].set(ind.second, 'X')

fun Array<CharArray>.findStartingPoint(): Pair<Int, Int> =
    mapIndexed { i, chars ->
        if (chars.any(directions::contains)) {
            i to chars.indexOfFirst { c -> directions.contains(c) }
        } else null
    }
        .filterNotNull()
        .single()

fun Array<CharArray>.getStartingDirection(ind: Pair<Int, Int>): Direction =
    when (this[ind.first][ind.second]) {
        '^' -> Up()
        'v' -> Down()
        '<' -> Left()
        '>' -> Right()
        else -> throw IllegalArgumentException()
    }

fun Array<CharArray>.countSteps(): Int =
    fold(0) { acc, charArray -> acc + charArray.countSteps() }

fun CharArray.countSteps(): Int =
    fold(0) { acc, c -> if (c == 'X') acc + 1 else acc }
