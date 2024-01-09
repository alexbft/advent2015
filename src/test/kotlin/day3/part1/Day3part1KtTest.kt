package day3.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3part1KtTest {

    @Test
    fun solve1() {
        assertEquals(2, solve(">"))
    }

    @Test
    fun solve2() {
        assertEquals(4, solve("^>v<"))
    }

    @Test
    fun solve3() {
        assertEquals(2, solve("^v^v^v^v^v"))
    }
}
