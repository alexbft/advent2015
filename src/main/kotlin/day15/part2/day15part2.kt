package day15.part2

import bootstrap.readLines

private fun recMaxScore(depth: Int, ingredientFactors: List<List<Int>>, parameters: List<Int>, freeSpace: Int): Long {
    if (depth >= ingredientFactors.size) {
        if (parameters.last() != 500) {
            return 0L
        }
        return parameters.subList(0, 4).fold(1L) { a, b -> if (b <= 0) 0L else a * b }
    }
    val minAmount = if (depth == ingredientFactors.lastIndex) freeSpace else 0
    return (minAmount..freeSpace).maxOf { amount ->
        val newParameters = parameters.mapIndexed { i, x ->
            x + ingredientFactors[depth][i] * amount
        }
        recMaxScore(depth + 1, ingredientFactors, newParameters, freeSpace - amount)
    }
}

fun solve(lines: List<String>): Long {
    val lineRe = """\w+: capacity (-?\d+), durability (-?\d+), flavor (-?\d+), texture (-?\d+), calories (-?\d+)""".toRegex()
    val ingredientFactors = lines.map { line ->
        val match = lineRe.matchEntire(line) ?: throw Exception("No match for $line")
        match.destructured.toList().map { it.toInt() }
    }
    return recMaxScore(0, ingredientFactors, listOf(0, 0, 0, 0, 0), 100)
}

fun main() {
    println(solve(readLines("day15.txt")))
}
