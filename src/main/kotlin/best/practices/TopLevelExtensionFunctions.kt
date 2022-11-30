package functional.programming

// In Java, you often create static util methods in util classes.
object StringUtil {
    fun countAmountOfX(string: String): Int {
        return string.length - string.replace("x", "").length
    }
}

// In Kotlin, remove the unnecessary wrapping util class and use top-level functions instead
// Often, you can additionally use extension functions, which increases readability ("like a story").
fun String.countAmountOfX(): Int {
    return length - replace("x", "").length
}

fun main(args: Array<String>) {
    println(StringUtil.countAmountOfX("xKotlinxFunx"))

    println("xKotlinxFunx".countAmountOfX())
}
