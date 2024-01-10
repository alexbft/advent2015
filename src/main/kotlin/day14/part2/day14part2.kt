package day14.part2

import bootstrap.readLines

private data class Reindeer(
    private val speed: Int,
    private val runTime: Int,
    private val restTime: Int,
) {
    private var isRunning = true
    private var timeLeft = runTime
    var distance = 0
        private set
    var score = 0

    fun processNextSecond() {
        if (isRunning) {
            distance += speed
        }
        timeLeft--
        if (timeLeft <= 0) {
            if (isRunning) {
                isRunning = false
                timeLeft = restTime
            } else {
                isRunning = true
                timeLeft = runTime
            }
        }
    }
}

fun solve(lines: List<String>, seconds: Int): Int {
    val lineRe = """\w+ can fly (\d+) km/s for (\d+) seconds, but then must rest for (\d+) seconds.""".toRegex()
    val reindeers = lines.map { line ->
        val match = lineRe.matchEntire(line) ?: throw Exception("no match for $line")
        val (speed, runTime, restTime) = match.destructured.toList().map { it.toInt() }
        Reindeer(speed, runTime, restTime)
    }
    for (time in 1..seconds) {
        reindeers.forEach { it.processNextSecond() }
        val maxDistance = reindeers.maxOf { it.distance }
        reindeers.filter { it.distance == maxDistance }.forEach { it.score++ }
    }
    return reindeers.maxOf { it.score }
}

fun main() {
    println(solve(readLines("day14.txt"), 2503))
}
