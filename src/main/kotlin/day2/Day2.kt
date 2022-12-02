package day2

import java.io.File

fun main() {
    println("Part 1 :")
    val resultPart1 = day1.part1("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart1")

    /*println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart2")*/
}

fun part1(path: String): Int {
    val matchs = decodeFile(path)
    return 0
}

fun decodeFile(path: String): List<Int> {
    val result = mutableListOf<Int>()
    File(path).readLines().forEach { match ->
        match.split(" ").let {
            result.add(decodeSingleLine(it[0][0], it[1][0]))
        }
    }
    return result
}

fun decodeSingleLine(player1Shape: Char, player2Shape: Char): Int {
    return 0
}

enum class Shape(
    private val player1: Char,
    private val player2: Char,
    val value: Int,
) {
    Rock('A', 'X', 1),
    Paper('B', 'Y', 2),
    Scissors('C', 'Z', 3),
}

fun Shape.against(shape: Shape): Int {
    return when {
        this == shape -> this.value
        else -> 0
    }
}