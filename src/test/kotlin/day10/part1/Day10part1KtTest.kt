package day10.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10part1KtTest {

    @Test
    fun transform1() {
        assertEquals("11", transform("1"))
    }

    @Test
    fun transform2() {
        assertEquals("21", transform("11"))
    }

    @Test
    fun transform3() {
        assertEquals("1211", transform("21"))
    }

    @Test
    fun transform4() {
        assertEquals("111221", transform("1211"))
    }

    @Test
    fun transform5() {
        assertEquals("312211", transform("111221"))
    }
}
