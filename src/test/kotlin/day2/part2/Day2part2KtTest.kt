package day2.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2part2KtTest {

    @Test
    fun solve() {
        val input = """
            2x3x4
            1x1x10
        """.trimIndent().lines()
        assertEquals(34 + 14, solve(input))
    }
}
