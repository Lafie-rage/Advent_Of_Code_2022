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
        val result = part1("./src/test/resources/day3/input.txt")

        assertEquals(157, result)
    }

    override fun `test part 2`() {

    }

}