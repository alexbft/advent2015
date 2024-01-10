package day17.part1

import bootstrap.readLines

fun solve(lines: List<String>, total: Int): Int {
    val volumes = lines.map { it.toInt() }
    val volToCombos = mutableMapOf(0 to 1)
    for (vol in volumes) {
        for ((k, v) in volToCombos.toMap()) {
            if (k + vol <= total) {
                volToCombos.merge(k + vol, v) { a, b -> a + b }
            }
        }
    }
    return volToCombos[total] ?: 0
}

fun main() {
    println(solve(readLines("day17.txt"), 150))
}
