package day18.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day18part2KtTest {

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
        assertEquals(17, solve(input, 5))
    }
}
