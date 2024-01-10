package day18.part1

import bootstrap.readLines

private fun nextState(state: BooleanArray, width: Int, height: Int): BooleanArray {
    return BooleanArray(width * height) { i ->
        val y = i / width
        val x = i % width
        var neighbors = 0
        val y0 = maxOf(y - 1, 0)
        val y1 = minOf(y + 1, height - 1)
        val x0 = maxOf(x - 1, 0)
        val x1 = minOf(x + 1, width - 1)
        for (yy in y0..y1) {
            for (xx in x0..x1) {
                if (state[yy * width + xx]) {
                    neighbors++
                }
            }
        }
        neighbors == 3 || (neighbors == 4 && state[i])
    }
}

fun solve(lines: List<String>, simTurns: Int): Int {
    val width = lines[0].length
    val height = lines.size
    var state = BooleanArray(width * height) { i ->
        val y = i / width
        val x = i % width
        lines[y][x] == '#'
    }
    repeat(simTurns) {
        state = nextState(state, width, height)
    }
    return state.count { it }
}

fun main() {
    println(solve(readLines("day18.txt"), 100))
}
