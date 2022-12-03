package day2

import java.io.File

fun main() {
    println("Part 1 :")
    val resultPart1 = part1("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart1")

    println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart2")
}

fun part1(path: String): Int {
    val tournament = decodeFile(path)
    val matchesScores = mutableListOf<Int>()
    tournament.forEach { match ->
        match.split(" ").let {
            matchesScores.add(decodeSingleLinePart1(it[0][0], it[1][0]))
        }
    }
    return matchesScores.sum()
}

fun part2(path: String): Int {
    val tournament = decodeFile(path)
    val matchesScores = mutableListOf<Int>()
    tournament.forEach { match ->
        match.split(" ").let {
            matchesScores.add(decodeSingleLinePart2(it[0][0], it[1][0]))
        }
    }
    return matchesScores.sum()
}

private fun decodeSingleLinePart1(opponentShape: Char, myShape: Char): Int =  shapeForOpponent(opponentShape).against(shapeForMe(myShape))

private fun decodeSingleLinePart2(opponentEncryptedShape: Char, intendedResult: Char): Int {
    val opponentShape = shapeForOpponent(opponentEncryptedShape)
    return opponentShape.against(shapeForIntendedResult(intendedResult, opponentShape))
}

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

// X : Rock
// Y : Paper
// Z : Scissors
private fun shapeForMe(myShape: Char): Shape =
    when (myShape) {
        'X' -> Shape.Rock
        'Y' -> Shape.Paper
        else -> Shape.Scissors
    }

// X : loose
// Y : draw
// Z : win
private fun shapeForIntendedResult(intendedResult: Char, opponentShape: Shape): Shape =
    when {
        intendedResult == 'X' && opponentShape == Shape.Rock ||
                intendedResult == 'Y' && opponentShape == Shape.Scissors ||
                intendedResult == 'Z' && opponentShape == Shape.Paper -> Shape.Scissors
        intendedResult == 'X' && opponentShape == Shape.Paper ||
                intendedResult == 'Y' && opponentShape == Shape.Rock ||
                intendedResult == 'Z' && opponentShape == Shape.Scissors -> Shape.Rock
        else -> Shape.Paper
    }

private fun Shape.against(myShape: Shape): Int =
    when {
        this == myShape -> 3 // Draw
        this == Shape.Scissors && myShape == Shape.Rock ||
                this == Shape.Rock && myShape == Shape.Paper ||
                this == Shape.Paper && myShape == Shape.Scissors -> 6 // Win
        else -> 0 // Loose
    } + myShape.score