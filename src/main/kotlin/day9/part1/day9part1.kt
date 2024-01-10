package day9.part1

import bootstrap.readLines

private fun minPathRec(lastNode: String, notVisited: Set<String>, distances: Map<Pair<String, String>, Int>): Int {
    if (notVisited.isEmpty()) {
        return 0
    }
    return notVisited.minOf { nextNode ->
        distances[lastNode to nextNode]!! + minPathRec(nextNode, notVisited - nextNode, distances)
    }
}

fun solve(lines: List<String>): Int {
    val lineRe = """(\w+) to (\w+) = (\d+)""".toRegex()
    val distances = lines.flatMap { line ->
        val match = lineRe.matchEntire(line) ?: throw Exception("No match at $line")
        val (nodeFrom, nodeTo, distanceStr) = match.destructured
        val distance = distanceStr.toInt()
        listOf(
            (nodeFrom to nodeTo) to distance,
            (nodeTo to nodeFrom) to distance,
        )
    }.toMap()
    val nodes = distances.keys.map { it.first }.toSet()
    return nodes.minOf { startNode ->
        minPathRec(startNode, nodes - startNode, distances)
    }
}

fun main() {
    println(solve(readLines("day9.txt")))
}
