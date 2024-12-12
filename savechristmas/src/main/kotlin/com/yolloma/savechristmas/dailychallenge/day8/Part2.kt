package com.yolloma.savechristmas.dailychallenge.day8

object Part2 {

    fun execute(input: List<String>): Int =
        input.getAntennae()
            .filter { it.value.size > 1 }
            .flatMap { (_, antennaList) -> antennaList.findAllAntinodes(input.iRange, input.jRange, ::findAll) }
            .toSet()
            .size

    fun findAll(an1: Antenna, an2: Antenna, iRange: IntRange, jRange: IntRange): List<Point> {
        val iDelta = an2.i - an1.i
        val jDelta = an2.j - an1.j

        return listOf(an1.point, an2.point)
            .plus(moveBy(an2, iDelta, jDelta, iRange, jRange))
            .plus(moveBy(an1, -iDelta, -jDelta, iRange, jRange))
    }

    private fun moveBy(
        antenna: Antenna,
        iDelta: Int,
        jDelta: Int,
        iRange: IntRange,
        jRange: IntRange
    ): List<Point> =
        generateSequence(1, Int::inc)
            .map { Point(antenna.i + (iDelta * it), antenna.j + (jDelta * it)) }
            .takeWhile { it.i in iRange && it.j in jRange }
            .toList()
}
