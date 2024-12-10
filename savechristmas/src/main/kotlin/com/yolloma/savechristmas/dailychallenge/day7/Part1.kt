package com.yolloma.savechristmas.dailychallenge.day7

class Part1 {

    fun execute(input: List<String>) {
        input.map(::asCalibrationEquation)

        println(0)
    }
}

fun asCalibrationEquation(s: String) =
    s.split(":")
        .let {
            Calibration(
                result = it.first().toInt(),
                testValues = it.last().trim().split(" ").map(String::toInt)
            )
        }

data class Calibration(val result: Int, val testValues: List<Int>)