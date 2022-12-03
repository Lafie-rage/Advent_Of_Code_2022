package day2

import java.io.File

fun main() {
    println("Part 1 :")
    val resultPart1 = part1("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart1")

    /*println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart2")*/
}

fun part1(path: String): Int {
    val tournament = decodeFile(path)
    val matchsScores = mutableListOf<Int>()
    tournament.forEach { match ->
        match.split(" ").let {
            matchsScores.add(decodeSingleLine_part1(it[0][0], it[1][0]))
        }
    }
    return matchsScores.sum()
}
private fun decodeSingleLine_part1(player1Shape: Char, player2Shape: Char): Int =  shapeForOpponent(player1Shape).against(shapeForMe(player2Shape))

private fun decodeFile(path: String): List<String> {
    return File(path).readLines()
}


private enum class Shape(
    val score: Int,
) {
    Rock(1),
    Paper(2),
    Scissors(3)
}

private fun shapeForOpponent(opponentShape: Char): Shape {
    return when (opponentShape) {
        'A' -> Shape.Rock
        'B' -> Shape.Paper
        else -> Shape.Scissors
    }
}

private fun shapeForMe(myShape: Char): Shape =
    when (myShape) {
        'X' -> Shape.Rock
        'Y' -> Shape.Paper
        else -> Shape.Scissors
    }

private fun Shape.against(shape: Shape): Int =
    when {
        this == shape -> 3
        this == Shape.Scissors && shape == Shape.Rock ||
                this == Shape.Rock && shape == Shape.Paper ||
                this == Shape.Paper && shape == Shape.Scissors -> 6
        else -> 0
    } + shape.score