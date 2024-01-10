package day6.part2

import bootstrap.readLines

fun solve(lines: List<String>): Int {
    val width = 1000
    val height = 1000
    val lights = IntArray(width * height) { 0 }
    val lineRe = """(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)""".toRegex()
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("No match for line $line")
        val (cmd, x0, y0, x1, y1) = match.destructured
        val fn: (x: Int) -> Int = when (cmd) {
            "turn on" -> ({ it + 1 })
            "turn off" -> ({ maxOf(0, it - 1) })
            "toggle" -> ({ it + 2 })
            else -> throw Exception("Unknown command $cmd")
        }
        for (y in y0.toInt()..y1.toInt()) {
            for (x in x0.toInt()..x1.toInt()) {
                val index = y * width + x
                lights[index] = fn(lights[index])
            }
        }
    }
    return lights.sum()
}

fun main() {
    println(solve(readLines("day6.txt")))
}
