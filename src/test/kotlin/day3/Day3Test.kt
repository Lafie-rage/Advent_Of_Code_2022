package day3

import BaseDayTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test : BaseDayTest() {

    @Test
    fun `test bag compartments comparison`() {
        val commons = Bag(
            "JjaAArRRssTTtUw",
            "PpPPmMmmnNtRs"
        ).findCommonItems().sorted()
        assertEquals("tRs".toList().sorted(), commons)
    }

    @Test
    override fun `test part 1`() {
        val result = part1(inputPath)

        assertEquals(157, result)
    }

    @Test
    override fun `test part 2`() {
        val result = part2(inputPath)

        assertEquals(70, result)
    }

}