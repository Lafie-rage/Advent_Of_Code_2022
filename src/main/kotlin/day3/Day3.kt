package day3

import java.io.File


fun main() {
    println("Part 1 :")
    val resultPart1 = part1("./src/main/resources/day3/input.txt")
    println("Answer : $resultPart1")

    println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day3/input.txt")
    println("Answer : $resultPart2")
}

fun part1(path: String): Int {
    val commonItems = mutableListOf<Char>()
    val bags = decodeFile(path)
    bags.forEach {
        commonItems.addAll(it.findCommonItems())
    }
    return commonItems.sum()
}

fun part2(path: String): Int {
    val bags = decodeFile(path)
    return bags.chunked(3).map {
        findBadge(it)
    }.sum()
}

private fun decodeFile(path: String): List<Bag> = File(path).readLines().map {
    Bag(
        compart1 = it.substring(0, it.length / 2),
        compart2 = it.substring(it.length / 2, it.length),
    )
}

data class Bag(
    val compart1: String,
    val compart2: String,
) {
    fun findCommonItems(): List<Char> {
        val compart1Distinct = compart1.toList().distinct()
        val compart2Distinct = compart2.toList().distinct()
        return (compart1Distinct + compart2Distinct).groupBy { it }.filter { it.value.size > 1 }.keys.toList()
    }
}

fun findBadge(bags: List<Bag>): Char {
    val bagsContent = mutableListOf<Char>()
    bagsContent.addAll(bags[0].compart1.toList().distinct() + bags[0].compart2.toList().distinct())
    bagsContent.addAll(bags[1].compart1.toList().distinct() + bags[1].compart2.toList().distinct())
    bagsContent.addAll(bags[2].compart1.toList().distinct() + bags[2].compart2.toList().distinct())
    return bagsContent.groupBy { it }.filter { it.value.size > 2 }.keys.firstOrNull()!!
}

private fun List<Char>.sum(): Int {
    var sum = 0
    this.forEach {
        if (it.isLowerCase()) {
            sum += (it - 'a' + 1)
        } else {
            sum += (it - 'A' + 27)
        }
    }
    return sum
}