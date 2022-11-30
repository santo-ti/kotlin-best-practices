package functional.programming

import com.jayway.jsonpath.JsonPath
import java.util.*

// Don't
fun getDefaultLocale(deliveryArea: String): Locale {
    val deliverAreaLower = deliveryArea.lowercase()
    if (deliverAreaLower == "germany" || deliverAreaLower == "austria") {
        return Locale.GERMAN
    }
    if (deliverAreaLower == "usa" || deliverAreaLower == "great britain") {
        return Locale.ENGLISH
    }
    if (deliverAreaLower == "france") {
        return Locale.FRENCH
    }
    return Locale.ENGLISH
}

// Do
// Rule of thumb: Every time you write an if consider if it can be replaced with a more concise when expression.
fun getDefaultLocale2(deliveryArea: String): Locale =
    when (deliveryArea.lowercase()) {
        "germany", "austria" -> Locale.GERMAN
        "usa", "great britain" -> Locale.ENGLISH
        "france" -> Locale.FRENCH
        else -> Locale.ENGLISH
    }

// try-catch is also a useful expression:
const val json = """{"message":"HELLO"}"""
val message: String = try {
    JsonPath.parse(json).read("message")
} catch (ex: Exception) {
    println("Error: ${ex.message}")
    json
}

fun main(args: Array<String>) {
    println(getDefaultLocale("germany"))
    println(getDefaultLocale2("austria"))
    println(message) //hello
}
