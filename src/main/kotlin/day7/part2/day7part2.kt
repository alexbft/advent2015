package day7.part2

import bootstrap.readLines

private data class Rule(val outputNode: String, val operation: Operation, val operands: List<Operand>)

private enum class Operation {
    Copy, Not, And, Or, Lshift, Rshift
}

private data class Operand(val node: String?, val value: Int?)

private fun parseOperand(s: String): Operand {
    val maybeInt = s.toIntOrNull()
    return if (maybeInt != null) Operand(null, maybeInt) else Operand(s, null)
}

private const val valueMask = (1 shl 16) - 1

fun solveFull(lines: List<String>, initialValues: Map<String, Int>): Map<String, Int> {
    val result = initialValues.toMutableMap()
    val rules = lines.map { line ->
        val (lSide, rSide) = line.split(" -> ")
        val parts = lSide.split(" ")
        when (parts.size) {
            1 -> Rule(rSide, Operation.Copy, listOf(parseOperand(parts[0])))
            2 -> {
                if (parts[0] != "NOT") {
                    throw Exception("Parse error: $line")
                }
                Rule(rSide, Operation.Not, listOf(parseOperand(parts[1])))
            }
            3 -> {
                val operation = when (parts[1]) {
                    "AND" -> Operation.And
                    "OR" -> Operation.Or
                    "LSHIFT" -> Operation.Lshift
                    "RSHIFT" -> Operation.Rshift
                    else -> throw Exception("Parse error: $line")
                }
                Rule(rSide, operation, listOf(parseOperand(parts[0]), parseOperand(parts[2])))
            }
            else -> throw Exception("Parse error: $line")
        }
    }
    do {
        var changed = false
        for (rule in rules) {
            if (rule.outputNode in result) {
                continue
            }
            val resolvedOperands = rule.operands.mapNotNull { op ->
                if (op.node != null) result[op.node] else op.value
            }
            if (resolvedOperands.size == rule.operands.size) {
                changed = true
                val op = resolvedOperands
                result[rule.outputNode] = when (rule.operation) {
                    Operation.Copy -> op[0]
                    Operation.Not -> op[0].inv() and valueMask
                    Operation.And -> op[0] and op[1]
                    Operation.Or -> op[0] or op[1]
                    Operation.Lshift -> (op[0] shl op[1]) and valueMask
                    Operation.Rshift -> op[0] shr op[1]
                }
            }
        }
    } while (changed)
    return result
}

private fun solve(lines: List<String>): Int {
    val a = solveFull(lines, emptyMap())["a"]!!
    return solveFull(lines, mapOf("b" to a))["a"]!!
}

fun main() {
    println(solve(readLines("day7.txt")))
}
