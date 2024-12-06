package com.yolloma.savechristmas.dailychallenge.day6

sealed class Direction(val iInc: Int, val jInc: Int) {
    abstract val next: Direction
}

class Down(iInc: Int = 1, jInc: Int = 0) : Direction(iInc, jInc) {
    override val next: Direction by lazy { Left() }
}

class Left(iInc: Int = 0, jInc: Int = -1) : Direction(iInc, jInc) {
    override val next: Direction by lazy { Up() }
}

class Right(iInc: Int = 0, jInc: Int = 1) : Direction(iInc, jInc) {
    override val next: Direction by lazy { Down() }
}

class Up(iInc: Int = -1, jInc: Int = 0) : Direction(iInc, jInc) {
    override val next: Direction by lazy { Right() }
}

val directions = listOf('^', 'v', '<', '>')
