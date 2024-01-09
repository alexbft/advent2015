package day5.part1

import bootstrap.readLines

fun isNice(line: String): Boolean {
    val vowels = line.count { it in "aeiou" }
    if (vowels < 3) {
        return false
    }
    if (line.zipWithNext().all { (a, b) -> a != b }) {
        return false
    }
    return listOf("ab", "cd", "pq", "xy").all { it !in line }
}

private fun solve(lines: List<String>): Int {
    return lines.count(::isNice)
}

fun main() {
    println(solve(readLines("day5.txt")))
}
