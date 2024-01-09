package day4.part2

import common.crypto.md5

private const val maxN = 100_000_000

fun solve(secret: String): Int {
    for (n in 1..maxN) {
        if (md5("$secret$n").startsWith("000000")) {
            return n
        }
    }
    throw Exception("Not found")
}

fun main() {
    println(solve("bgvyzdsv"))
}
