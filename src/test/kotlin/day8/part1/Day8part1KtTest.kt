package day8.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day8part1KtTest {

    @Test
    fun solve1() {
        val input = """
            ""
        """.trimIndent().lines()
        assertEquals(2, solve(input))
    }

    @Test
    fun solve2() {
        val input = """
            "abc"
        """.trimIndent().lines()
        assertEquals(2, solve(input))
    }

    @Test
    fun solve3() {
        val input = """
            "aaa\"aaa"
        """.trimIndent().lines()
        assertEquals(3, solve(input))
    }

    @Test
    fun solve4() {
        val input = """
            "\x27"
        """.trimIndent().lines()
        assertEquals(5, solve(input))
    }
}
