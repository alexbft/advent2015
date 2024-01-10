package day17.part2

import bootstrap.readLines

private data class Score(val numContainers: Int, val ways: Int)

fun solve(lines: List<String>, total: Int): Int {
    val volumes = lines.map { it.toInt() }
    val volToCombos = mutableMapOf(0 to Score(0, 1))
    for (vol in volumes) {
        for ((k, v) in volToCombos.toMap()) {
            val newVol = k + vol
            if (newVol <= total) {
                val newScore = Score(v.numContainers + 1, v.ways)
                volToCombos.merge(newVol, newScore) { prev, new ->
                    when {
                        prev.numContainers < new.numContainers -> prev
                        prev.numContainers == new.numContainers -> Score(new.numContainers, prev.ways + new.ways)
                        else -> new
                    }
                }
            }
        }
    }
    return volToCombos[total]?.ways ?: 0
}

fun main() {
    println(solve(readLines("day17.txt"), 150))
}
