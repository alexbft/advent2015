package day7.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7part1KtTest {

    @Test
    fun solveFull() {
        val input = """
            123 -> x
            456 -> y
            x AND y -> d
            x OR y -> e
            x LSHIFT 2 -> f
            y RSHIFT 2 -> g
            NOT x -> h
            NOT y -> i
        """.trimIndent().lines()
        val expected = mapOf(
            "d" to 72,
            "e" to 507,
            "f" to 492,
            "g" to 114,
            "h" to 65412,
            "i" to 65079,
            "x" to 123,
            "y" to 456,
        )
        assertEquals(expected, solveFull(input))
    }
}
