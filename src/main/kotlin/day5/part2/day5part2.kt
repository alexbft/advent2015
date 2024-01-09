package day5.part2

import bootstrap.readLines

fun isNice(line: String): Boolean {
    var p1 = '_'
    var p2 = '_'
    var hasAba = false
    val pairPos = mutableMapOf<String, Int>()
    var hasPair = false
    for ((i, c) in line.withIndex()) {
        if (p2 == c) {
            hasAba = true
        }
        val lastPair = "$p1$c"
        val lastPairPos = pairPos[lastPair]
        if (lastPairPos != null && lastPairPos < i - 1) {
            hasPair = true
        }
        if (lastPairPos == null) {
            pairPos[lastPair] = i
        }
        p2 = p1
        p1 = c
    }
    return hasAba && hasPair
}

private fun solve(lines: List<String>): Int {
    return lines.count(::isNice)
}

fun main() {
    println(solve(readLines("day5.txt")))
}
