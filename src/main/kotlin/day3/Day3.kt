package day3

import java.io.File


fun main() {
    println("Part 1 :")
    val resultPart1 = part1("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart1")

   /* println("Part 2 :")
    val resultPart2 = part2("./src/main/resources/day2/input.txt")
    println("Answer : $resultPart2")*/
}

fun part1(path: String): Int {
    val bags = decodeFile(path)
    bags.forEach {

    }
    return 0
}

private fun decodeFile(path: String): List<Bag> = File(path).readLines().map {
        Bag(
            compart1 = it.substring(0, it.length/2),
            compart2 = it.substring(it.length/2, it.length),
        )
    }

private data class Bag(
    val compart1: String,
    val compart2: String,
) {
    fun findCommonItems() = {
        val compart1Distinct = compart1.toList().distinct()
        val compart2Distinct = compart2.toList().distinct()
        (compart1Distinct + compart2Distinct)
    }
}