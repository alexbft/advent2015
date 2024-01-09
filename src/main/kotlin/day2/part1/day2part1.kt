package day2.part1

import bootstrap.readLines

fun solve(lines: List<String>): Int {
    return lines.sumOf { line ->
        val (l, w, h) = line.split("x").map { it.toInt() }
        val sides = listOf(l * w, w * h, l * h)
        val minSide = sides.min()
        2 * sides.sum() + minSide
    }
}

fun main() {
    println(solve(readLines("day2.txt")))
}
