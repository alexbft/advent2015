package day4.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day4part1KtTest {

    @Test
    fun solve1() {
        assertEquals(609043, solve("abcdef"))
    }

    @Test
    fun solve2() {
        assertEquals(1048970, solve("pqrstuv"))
    }
}
