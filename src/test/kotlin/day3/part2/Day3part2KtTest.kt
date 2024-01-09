package day3.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3part2KtTest {
    @Test
    fun solve1() {
        assertEquals(3, solve("^v"))
    }

    @Test
    fun solve2() {
        assertEquals(3, solve("^>v<"))
    }

    @Test
    fun solve3() {
        assertEquals(11, solve("^v^v^v^v^v"))
    }
}
