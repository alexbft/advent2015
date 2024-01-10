package day8.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day8part2KtTest {

    @Test
    fun solve() {
        val input = """
            ""
            "abc"
            "aaa\"aaa"
            "\x27"
        """.trimIndent().lines()
        assertEquals(19, solve(input))
    }
}
