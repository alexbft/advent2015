package day11.part1

private const val base = 'z' - 'a' + 1
private val bannedDigits = listOf('i' - 'a', 'o' - 'a', 'l' - 'a')

private fun toDigits(s: String): MutableList<Int> {
    return s.map { it - 'a' }.toMutableList()
}

private fun fromDigits(a: List<Int>): String {
    return a.map { 'a' + it }.joinToString("")
}

private fun isValid(a: List<Int>): Boolean {
    if (bannedDigits.any { it in a }) {
        return false
    }
    var p1 = -1
    var p2 = -1
    var hasStraight = false
    var lastPairPos = -1
    var hasTwoPairs = false
    for ((i, x) in a.withIndex()) {
        if (!hasStraight && i >= 2 && p1 == x - 1 && p2 == x - 2) {
            hasStraight = true
        }
        if (!hasTwoPairs) {
            if (x == p1) {
                if (lastPairPos == -1) {
                    lastPairPos = i
                } else if (i - lastPairPos >= 2) {
                    hasTwoPairs = true
                }
            }
        }
        p2 = p1
        p1 = x
    }
    return hasStraight && hasTwoPairs
}

private fun inc(a: MutableList<Int>) {
    var i = a.lastIndex
    ++a[i]
    while (a[i] >= base) {
        a[i] = 0
        --i
        ++a[i]
    }
}

fun solve(seed: String): String {
    val cur = toDigits(seed)
    inc(cur)
    while (!isValid(cur)) {
        inc(cur)
    }
    return fromDigits(cur)
}

fun main() {
    println(solve("vzbxkghb"))
}
