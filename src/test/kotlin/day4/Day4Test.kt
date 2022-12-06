package day4

import BaseDayTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test : BaseDayTest() {

    @Test
    override fun `test part 1`() {
        val result = part1(inputPath)
        assertEquals(2, result)
    }

    @Test
    override fun `test part 2`() {
    }
}