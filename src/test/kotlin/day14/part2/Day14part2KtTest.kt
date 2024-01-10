package day14.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day14part2KtTest {

    @Test
    fun solve() {
        val input = """
            Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.
            Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.
        """.trimIndent().lines()
        assertEquals(689, solve(input, 1000))
    }
}
