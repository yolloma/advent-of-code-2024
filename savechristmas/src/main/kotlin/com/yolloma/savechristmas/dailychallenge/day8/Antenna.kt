package com.yolloma.savechristmas.dailychallenge.day8

data class Antenna(val i: Int, val j: Int, val id: Char) {
    val point: Point = Point(i, j)
}

data class Point(val i: Int, val j: Int)

fun List<String>.getAntennae(): Map<Char, List<Antenna>> =
    flatMapIndexed { i, jString ->
        jString.mapIndexed { j, c ->
            if (c != '.') Antenna(i, j, c) else null
        }
    }
        .filterNotNull()
        .groupBy(Antenna::id)

fun List<Antenna>.findAllAntinodes(
    iRange: IntRange,
    jRange: IntRange,
    findAntinodes: (Antenna, Antenna, IntRange, IntRange) -> List<Point>
) =
    flatMapIndexed { index, antenna ->
        this.drop(index + 1).flatMap { other ->
            findAntinodes(antenna, other, iRange, jRange)
        }
    }

val List<String>.iRange: IntRange
    get() = indices

val List<String>.jRange: IntRange
    get() = first().indices
