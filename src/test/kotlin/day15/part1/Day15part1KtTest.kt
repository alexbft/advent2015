package day15.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day15part1KtTest {

    @Test
    fun solve() {
        val input = """
            Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8
            Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3
        """.trimIndent().lines()
        assertEquals(62842880L, solve(input))
    }
}
