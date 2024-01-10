package day18.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day18part1KtTest {

    @Test
    fun solve() {
        val input = """
            .#.#.#
            ...##.
            #....#
            ..#...
            #.#..#
            ####..
        """.trimIndent().lines()
        assertEquals(4, solve(input, 4))
        assertEquals(4, solve(input, 100))
    }
}
