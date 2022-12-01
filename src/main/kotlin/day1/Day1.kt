package day1

import java.io.File

fun main() {
    println("Part 1 :")
    part1()
}
fun part1() {
    val elvesCalories = mutableListOf<Int>()

    val elves = File("./src/main/resources/day1/input.txt").readText().split("\n\n")

    elves.forEachIndexed { i, elf ->
        elf.split("\n").forEach { calories ->
            if(elvesCalories.size == i) elvesCalories.add(0)
            elvesCalories[i] += calories.toInt()
        }
    }

    println("\tAnswer : ${elvesCalories.maxOrNull()}")
}