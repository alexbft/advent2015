package day16.part2

import bootstrap.readLines

private typealias Condition = (v: Int) -> Boolean

fun solve(lines: List<String>, lookFor: Map<String, Condition>): Int {
    val lineRe = """Sue (\d+): (.+)""".toRegex()
    for (line in lines) {
        val match = lineRe.matchEntire(line) ?: throw Exception("No match for $line")
        val (id, componentsStr) = match.destructured
        val components = componentsStr.split(", ").map { componentStr ->
            val (name, amount) = componentStr.split(": ")
            name to amount.toInt()
        }
        if (components.all { (k, v) -> lookFor[k]!!(v) }) {
            return id.toInt()
        }
    }
    throw Exception("Not found")
}

fun main() {
    val lookFor = mapOf<String, Condition>(
        "children" to { it == 3 },
        "cats" to { it > 7 },
        "samoyeds" to { it == 2 },
        "pomeranians" to { it < 3 },
        "akitas" to { it == 0 },
        "vizslas" to { it == 0 },
        "goldfish" to { it < 5 },
        "trees" to { it > 3 },
        "cars" to { it == 2 },
        "perfumes" to { it == 1 },
    )
    println(solve(readLines("day16.txt"), lookFor))
}
