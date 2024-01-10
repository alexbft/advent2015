package day12.part1

import bootstrap.readLines

fun solve(text: String): Int {
    val numsRe = """-?\d+""".toRegex()
    return numsRe.findAll(text).sumOf { it.value.toInt() }
}

fun main() {
    println(solve(readLines("day12.txt").single()))
}
