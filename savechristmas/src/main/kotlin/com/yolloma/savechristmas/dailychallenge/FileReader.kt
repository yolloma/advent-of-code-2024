package com.yolloma.savechristmas.dailychallenge

object FileReader {

    fun readIntLists(filename: String): Pair<MutableList<Int>, MutableList<Int>> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        readLines(filename)
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
        readLines(filename)
            .map { line ->
                line.split(" ")
                    .map(String::toInt)

            }

    fun readArray(filename: String): Array<CharArray> =
        readLines(filename)
            .map { it.toCharArray() }
            .toTypedArray()


    fun readString(filename: String): String =
        ClassLoader.getSystemResource(filename)
            .readText()

    fun readLines(filename: String): List<String> =
        readString(filename)
            .lines()
}
