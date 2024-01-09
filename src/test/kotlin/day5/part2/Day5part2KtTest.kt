package day5.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day5part2KtTest {

    @Test
    fun isNice1() {
        assertEquals(true, isNice("qjhvhtzxzqqjkmpb"))
    }

    @Test
    fun isNice2() {
        assertEquals(true, isNice("xxyxx"))
    }

    @Test
    fun isNice3() {
        assertEquals(false, isNice("uurcxstgmygtbstg"))
    }

    @Test
    fun isNice4() {
        assertEquals(false, isNice("ieodomkazucvgmuy"))
    }

    @Test
    fun isNice5() {
        assertEquals(false, isNice("aaa"))
    }

    @Test
    fun isNice6() {
        assertEquals(true, isNice("aaaa"))
    }
}
