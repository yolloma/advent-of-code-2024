package com.yolloma.savechristmas.dailychallenge

object FileReader {

    fun readIntLists(filename: String): Pair<MutableList<Int>, MutableList<Int>> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        ClassLoader.getSystemResource(filename)
            .readText()
            .lines()
            .forEach { line ->
                line.split("   ")
                    .map(String::toInt)
                    .let {
                        list1.add(it.first())
                        list2.add(it.last())
                    }
            }

        return list1 to list2
    }

    fun readReportLevels(filename: String): List<List<Int>> =
        ClassLoader.getSystemResource(filename)
            .readText()
            .lines()
            .map { line ->
                line.split(" ")
                    .map(String::toInt)

            }

    fun readString(filename: String): String =
        ClassLoader.getSystemResource(filename)
            .readText()
}
