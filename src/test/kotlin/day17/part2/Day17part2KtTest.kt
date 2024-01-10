package day17.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day17part2KtTest {

    @Test
    fun solve() {
        val input = """
            20
            15
            10
            5
            5
        """.trimIndent().lines()
        assertEquals(3, solve(input, 25))
    }
}
