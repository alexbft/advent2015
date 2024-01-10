package day11.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day11part1KtTest {

    @Test
    fun solve1() {
        assertEquals("abcdffaa", solve("abcdefgh"))
    }

    @Test
    fun solve2() {
        assertEquals("ghjaabcc", solve("ghijklmn"))
    }
}
