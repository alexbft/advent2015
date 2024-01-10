package day6.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6part1KtTest {

    @Test
    fun solve() {
        val input = """
            turn on 0,0 through 999,999
            toggle 0,0 through 999,0
            turn off 499,499 through 500,500
        """.trimIndent().lines()
        assertEquals(1_000_000 - 1_000 - 4, solve(input))
    }
}
