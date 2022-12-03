package day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

    @Test
    fun `test part 1`() {
        val result = part1("./src/test/resources/day2/input.txt")

        assertEquals(15, result)
    }

    @Test
    fun `test part 2`() {
        val result = part2("./src/test/resources/day2/input.txt")

        assertEquals(12, result)
    }
}