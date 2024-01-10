package day8.part2

import bootstrap.readLines

fun solve(lines: List<String>): Int {
    return lines.sumOf { line ->
        2 + line.count { it == '"' || it == '\\' }
    }
}

fun main() {
    println(solve(readLines("day8.txt")))
}
