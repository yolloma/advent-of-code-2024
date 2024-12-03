package com.yolloma.savechristmas.dailychallenge.day2

import com.yolloma.savechristmas.dailychallenge.FileReader

object Day2Solver {

    fun execute(){
        val input = FileReader.readReportLevels("day2_input.txt")

        CountSafeReports.execute(input)
            .also { println("Count of safe levels: $it")}
    }
}