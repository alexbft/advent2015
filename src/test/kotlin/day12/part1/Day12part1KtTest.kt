package day12.part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day12part1KtTest {

    @Test
    fun solve() {
        val input = """
            [1,2,3]
            {"a":2,"b":4}
            [[[3]]]
            {"a":{"b":4},"c":-1}
            {"a":[-1,1]}
            [-1,{"a":1}]
            []
            {}
        """.trimIndent()
        assertEquals(18, solve(input))
    }
}
