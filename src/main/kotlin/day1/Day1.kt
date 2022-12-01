package day1

import java.io.File

fun main() {
    println("Part 1 :")
    val resultPart1 = part1("./src/main/resources/day1/input.txt")
    println("Answer : $resultPart1")

    println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day1/input.txt")
    println("Answer : $resultPart2")
}
fun part1(path : String): Int {
    val elvesCalories = decodeFile(path)

    return elvesCalories.maxOrNull()!!
}

fun part2(path: String): Int {
    val elvesCalories = decodeFile(path).sortedDescending()

    return elvesCalories[0] + elvesCalories[1] + elvesCalories[2]
}
private fun decodeFile(path: String): List<Int> {
    val elvesCalories = mutableListOf<Int>()

    val elves = File(path).readText().split("\n\n")

    elves.forEachIndexed { i, elf ->
        elf.split("\n").forEach { calories ->
            if(elvesCalories.size == i) elvesCalories.add(0)
            elvesCalories[i] += calories.toInt()
        }
    }

    return elvesCalories
}