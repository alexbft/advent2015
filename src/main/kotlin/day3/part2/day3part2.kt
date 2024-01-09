package day3.part2

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
    var cur2 = cur
    for (cs in line.chunked(2)) {
        cur += dirMap[cs[0]]!!
        positions.add(cur)
        if (cs.length > 1) {
            cur2 += dirMap[cs[1]]!!
            positions.add(cur2)
        }
    }
    return positions.size
}

fun main() {
    println(solve(readLines("day3.txt").single()))
}
