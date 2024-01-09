package day5.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day5part1KtTest {

    @Test
    fun isNice1() {
        assertEquals(true, isNice("ugknbfddgicrmopn"))
    }

    @Test
    fun isNice2() {
        assertEquals(true, isNice("aaa"))
    }

    @Test
    fun isNice3() {
        assertEquals(false, isNice("jchzalrnumimnmhp"))
    }

    @Test
    fun isNice4() {
        assertEquals(false, isNice("haegwjzuvuyypxyu"))
    }

    @Test
    fun isNice5() {
        assertEquals(false, isNice("dvszwmarrgswjxmb"))
    }
}
