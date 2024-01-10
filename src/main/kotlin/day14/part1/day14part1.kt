package day14.part1

import bootstrap.readLines

fun solve(lines: List<String>, seconds: Int): Int {
    val lineRe = """\w+ can fly (\d+) km/s for (\d+) seconds, but then must rest for (\d+) seconds.""".toRegex()
    return lines.maxOf { line ->
        val match = lineRe.matchEntire(line) ?: throw Exception("no match for $line")
        val (speed, runTime, restTime) = match.destructured.toList().map { it.toInt() }
        val period = runTime + restTime
        val travelPerPeriod = speed * runTime
        val travel0 = (seconds / period) * travelPerPeriod
        val timeLeft = seconds % period
        val travel1 = speed * minOf(runTime, timeLeft)
        travel0 + travel1
    }
}

fun main() {
    println(solve(readLines("day14.txt"), 2503))
}
