package day1.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1part2KtTest {

    @Test
    fun solve1() {
        assertEquals(1, solve(")"))
    }

    @Test
    fun solve2() {
        assertEquals(5, solve("()())"))
    }
}
