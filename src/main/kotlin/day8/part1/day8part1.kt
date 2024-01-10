package day8.part1

import bootstrap.readLines

fun solve(lines: List<String>): Int {
    return lines.sumOf { line ->
        var i = 0
        var charCounter = 0
        while (i < line.length) {
            if (line[i] != '\\') {
                ++i
                ++charCounter
                continue
            }
            ++i
            when (line[i]) {
                '\\', '"' -> {
                    ++i
                    ++charCounter
                }
                'x' -> {
                    i += 3
                    ++charCounter
                }
                else -> {
                    throw Exception("Invalid escape sequence in line $line at pos $i")
                }
            }
        }
        line.length - (charCounter - 2)
    }
}

fun main() {
    println(solve(readLines("day8.txt")))
}
