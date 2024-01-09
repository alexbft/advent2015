package day2.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2part1KtTest {

    @Test
    fun solve() {
        val input = """
            2x3x4
            1x1x10
        """.trimIndent().lines()
        assertEquals(58 + 43, solve(input))
    }
}
