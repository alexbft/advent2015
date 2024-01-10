package day17.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day17part1KtTest {

    @Test
    fun solve() {
        val input = """
            20
            15
            10
            5
            5
        """.trimIndent().lines()
        assertEquals(4, solve(input, 25))
    }
}
