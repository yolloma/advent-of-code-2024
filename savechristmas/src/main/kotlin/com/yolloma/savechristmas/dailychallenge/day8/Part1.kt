package com.yolloma.savechristmas.dailychallenge.day8

object Part1 {

    fun execute(input: List<String>): Int =
        input.getAntennae()
            .flatMap { (_, antennaList) ->
                antennaList.findAllAntinodes(input.iRange, input.jRange, ::findAntinodes)
            }
            .toSet()
            .size

    fun findAntinodes(an1: Antenna, an2: Antenna, iRange: IntRange, jRange: IntRange): List<Point> {
        val iDelta = an2.i - an1.i
        val jDelta = an2.j - an1.j

        return listOfNotNull(
            moveBy(an2, iDelta, jDelta, iRange, jRange),
            moveBy(an1, -iDelta, -jDelta, iRange, jRange)
        )
    }

    private fun moveBy(antenna: Antenna, iDelta: Int, jDelta: Int, iRange: IntRange, jRange: IntRange): Point? =
        Point(antenna.i + iDelta, antenna.j + jDelta)
            .takeIf { it.i in iRange && it.j in jRange }
}
