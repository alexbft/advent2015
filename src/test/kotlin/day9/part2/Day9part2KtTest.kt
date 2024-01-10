package day9.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day9part2KtTest {

    @Test
    fun solve() {
        val input = """
            London to Dublin = 464
            London to Belfast = 518
            Dublin to Belfast = 141
        """.trimIndent().lines()
        assertEquals(982, solve(input))
    }
}
