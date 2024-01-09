package day1.part2

import bootstrap.readLines

fun solve(line: String): Int {
    return line.foldIndexed(0 to -1) { i, (acc, first), c ->
        val newAcc = acc + if (c == '(') 1 else -1
        val newFirst = if (first == -1 && newAcc < 0) i else first
        newAcc to newFirst
    }.second + 1
}

fun main() {
    println(solve(readLines("day1.txt").single()))
}
