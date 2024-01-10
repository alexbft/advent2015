package day10.part2

fun transform(s: String): String {
    return buildString {
        var prev = '_'
        var repeatCount = 1
        for (c in s) {
            if (c == prev) {
                ++repeatCount
            } else {
                if (prev != '_') {
                    append(repeatCount)
                    append(prev)
                }
                prev = c
                repeatCount = 1
            }
        }
        append(repeatCount)
        append(prev)
    }
}

fun solve(line: String): Int {
    var cur = line
    repeat(50) {
        cur = transform(cur)
    }
    return cur.length
}

fun main() {
    println(solve("1113222113"))
}
