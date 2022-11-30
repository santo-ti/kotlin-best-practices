package best.practices

class OtherService {
    fun getCustomer(text: String): String {
        return text
    }
}

//Don't
fun notNull(order: Order?): String {
    val city = order!!.customer!!.address!!.city ?: throw NullPointerException("Invalid Order")
    //...
    //..
    val service = OtherService();
    return service.getCustomer(city)
}

//Do
fun nullSafe(order: Order?): String {
    // Every time you write an if-null check, hold on. Kotlin provides much better ways to handle nulls.
    // Often, you can use null-safe call (?.) or the elvis operator (?:) instead.
    val city = order?.customer?.address?.city ?: throw IllegalArgumentException("Invalid Order")
    //...
    //..
    val service = OtherService();
    return service.getCustomer(city)
}

fun main(args: Array<String>) {
    println(notNull(null))

    try {
        println("notNull:")
        println(notNull(null))
    } catch (ex: NullPointerException) {
        println("Exception: ${ex.message}")
    }
}