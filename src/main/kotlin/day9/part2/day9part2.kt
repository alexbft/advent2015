package day9.part2

import bootstrap.readLines

private fun maxPathRec(lastNode: String, notVisited: Set<String>, distances: Map<Pair<String, String>, Int>): Int {
    if (notVisited.isEmpty()) {
        return 0
    }
    return notVisited.maxOf { nextNode ->
        distances[lastNode to nextNode]!! + maxPathRec(nextNode, notVisited - nextNode, distances)
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
    return nodes.maxOf { startNode ->
        maxPathRec(startNode, nodes - startNode, distances)
    }
}

fun main() {
    println(solve(readLines("day9.txt")))
}
