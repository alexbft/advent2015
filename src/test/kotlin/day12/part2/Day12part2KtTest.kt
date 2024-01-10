package day12.part2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day12part2KtTest {

    @Test
    fun solve1() {
        assertEquals(6, solve("""[1,2,3]"""))
    }

    @Test
    fun solve2() {
        assertEquals(4, solve("""[1,{"c":"red","b":2},3]"""))
    }

    @Test
    fun solve3() {
        assertEquals(0, solve("""{"d":"red","e":[1,2,3,4],"f":5}"""))
    }

    @Test
    fun solve4() {
        assertEquals(6, solve("""[1,"red",5]"""))
    }
}
