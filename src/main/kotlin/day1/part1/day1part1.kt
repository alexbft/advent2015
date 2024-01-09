package day1.part1

import bootstrap.readLines

fun solve(line: String): Int {
    return line.count { it == '(' } - line.count { it == ')' }
}

fun main() {
    println(solve(readLines("day1.txt").single()))
}
