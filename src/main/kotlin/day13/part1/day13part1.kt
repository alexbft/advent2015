package day13.part1

import bootstrap.readLines

private fun recMax(first: String, last: String, notVisited: Set<String>, happy: Map<Pair<String, String>, Int>): Int {
    if (notVisited.isEmpty()) {
        return happy[last to first]!! + happy[first to last]!!
    }
    return notVisited.maxOf { next ->
        happy[last to next]!! + happy[next to last]!! + recMax(first, next, notVisited - next, happy)
    }
}

fun solve(lines: List<String>): Int {
    val lineRe = """(\w+) would (gain|lose) (\d+) happiness units by sitting next to (\w+).""".toRegex()
    val happy = lines.associate { line ->
        val match = lineRe.matchEntire(line) ?: throw Exception("No match at $line")
        val (a, sign, value, b) = match.destructured
        val valueNum = (if (sign == "gain") 1 else -1) * value.toInt()
        (a to b) to valueNum
    }
    val nodes = happy.keys.map { it.first }.toSet()
    return recMax(nodes.first(), nodes.first(), nodes - nodes.first(), happy)
}

fun main() {
    println(solve(readLines("day13.txt")))
}
