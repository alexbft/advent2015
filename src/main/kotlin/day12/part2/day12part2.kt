package day12.part2

import bootstrap.readLines
import kotlinx.serialization.json.*

private fun isRed(jsonElement: JsonElement): Boolean {
    return jsonElement is JsonPrimitive && jsonElement.isString && jsonElement.content == "red"
}

private fun recSum(jsonElement: JsonElement): Int {
    return when (jsonElement) {
        is JsonPrimitive -> {
            val primitive = jsonElement.jsonPrimitive
            if (primitive.isString) 0 else primitive.content.toInt()
        }

        is JsonArray -> {
            jsonElement.jsonArray.sumOf(::recSum)
        }

        is JsonObject -> {
            val obj = jsonElement.jsonObject
            if (obj.values.any(::isRed)) 0 else obj.values.sumOf(::recSum)
        }

        else -> throw Exception("unreachable")
    }
}

fun solve(text: String): Int {
    val root = Json.parseToJsonElement(text)
    return recSum(root)
}

fun main() {
    println(solve(readLines("day12.txt").single()))
}
