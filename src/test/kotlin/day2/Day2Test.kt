package day2

import BaseDayTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test: BaseDayTest() {

    @Test
    override fun `test part 1`() {
        val result = part1(inputPath)

        assertEquals(15, result)
    }

    @Test
    override fun `test part 2`() {
        val result = part2(inputPath)

        assertEquals(12, result)
    }
}