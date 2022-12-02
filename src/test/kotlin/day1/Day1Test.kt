package day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun `test part 1`() {
        val result = part1("./src/test/resources/day1/input.txt")
        assertEquals(24000, result)
    }

    @Test
    fun `test part 2`() {
        val result = part2("./src/test/resources/day1/input.txt")
        assertEquals(45000, result)
    }

}