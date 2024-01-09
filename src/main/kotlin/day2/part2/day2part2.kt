package day2.part2

import bootstrap.readLines

fun solve(lines: List<String>): Int {
    return lines.sumOf { line ->
        val dimensions = line.split("x").map { it.toInt() }.sorted()
        val volume = dimensions.reduce { a, b -> a * b }
        2 * (dimensions[0] + dimensions[1]) + volume
    }
}

fun main() {
    println(solve(readLines("day2.txt")))
}
