package day1.part1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day1part1KtTest {
    @ParameterizedTest
    @CsvSource(
        "(()),0",
        "()(),0",
        "(((,3",
        "(()(()(,3",
        "))(((((,3",
        "()),-1",
        "))(,-1",
        "))),-3",
        ")())()),-3",
    )
    fun solve(input: String, expected: Int) {
        assertEquals(expected, solve(input))
    }
}
