package day4

import java.io.File

fun main() {

    println("Part 1 :")
    val resultPart1 = part1("./src/main/resources/day4/input.txt")
    println("Answer : $resultPart1")
    /*
    println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day4/input.txt")
    println("Answer : $resultPart2")*/
}

fun part1(path: String): Int {
    val elvesRanges = decodeFile(path)

    return elvesRanges.filter {
        it.first.containsAll(it.second) || it.second.containsAll(it.first)
    }.size
}

private fun decodeFile(path: String): List<Pair<List<Int>, List<Int>>> = File(path).readLines().map {
    it.split(",").let {
        Pair(it[0].split("-").let {
            IntRange(it[0].toInt(), it[1].toInt()).toList()
        }, it[1].split("-").let {
            IntRange(it[0].toInt(), it[1].toInt()).toList()
        })
    }
}
