package day3.part1

import bootstrap.readLines
import common.geom.Vector2

fun solve(line: String): Int {
    val positions = mutableSetOf(Vector2(0, 0))
    val dirMap = mapOf(
        '^' to Vector2(0, -1),
        'v' to Vector2(0, 1),
        '<' to Vector2(-1, 0),
        '>' to Vector2(1, 0),
    )
    var cur = positions.single()
    for (c in line) {
        cur += dirMap[c]!!
        positions.add(cur)
    }
    return positions.size
}

fun main() {
    println(solve(readLines("day3.txt").single()))
}
