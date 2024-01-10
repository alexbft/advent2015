package day16.part1

import bootstrap.readLines

fun solve(lines: List<String>, lookFor: Map<String, Int>): Int {
    val lineRe = """Sue (\d+): (.+)""".toRegex()
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("No match for $line")
        val (id, componentsStr) = match.destructured
        val components = componentsStr.split(", ").map { componentStr ->
            val (name, amount) = componentStr.split(": ")
            name to amount.toInt()
        }
        if (components.all { (k, v) -> lookFor[k] == v }) {
            return id.toInt()
        }
    }
    throw Exception("Not found")
}

fun main() {
    val lookFor = mapOf(
        "children" to 3,
        "cats" to 7,
        "samoyeds" to 2,
        "pomeranians" to 3,
        "akitas" to 0,
        "vizslas" to 0,
        "goldfish" to 5,
        "trees" to 3,
        "cars" to 2,
        "perfumes" to 1,
    )
    println(solve(readLines("day16.txt"), lookFor))
}
