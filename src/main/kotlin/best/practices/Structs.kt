package best.practices

// due to `to` infix function to create a Pair and static methods to create lists and maps,
// defining structs (like JSON) is reasonable in kotlin.
val customer = mapOf(
    "name" to "Clair Grube",
    "age" to 30,
    "languages" to listOf("german", "english"),
    "address" to mapOf(
        "city" to "Leipzig",
        "street" to "Karl-Liebknecht-Straße 1",
        "zipCode" to "04107"
    )
)

fun main(args: Array<String>) {
    println(customer)
}