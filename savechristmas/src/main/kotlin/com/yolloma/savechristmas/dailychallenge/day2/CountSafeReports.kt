package com.yolloma.savechristmas.dailychallenge.day2

object CountSafeReports {

    fun execute(input: List<List<Int>>) =
        input.map(CheckReportIsSafe::execute).count { it }
}