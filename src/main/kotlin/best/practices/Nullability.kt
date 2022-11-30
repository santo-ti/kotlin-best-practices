package best.practices

data class Order(val customer: Customer?)
data class Customer(val address: Address?)
data class Address(val city: String)

// Avoid if-null Checks
//Don't
fun ship(order: Order?): String {
    //every time you do if-null-checks, hold on.
    if (order == null || order.customer == null || order.customer.address == null) {
        throw IllegalArgumentException("Invalid Order")
    }
    val city = order.customer.address.city
    return city
}

//Do
fun ship2(order: Order?): String {
    // Every time you write an if-null check, hold on. Kotlin provides much better ways to handle nulls.
    // Often, you can use null-safe call (?.) or the elvis operator (?:) instead.
    val city = order?.customer?.address?.city ?: throw IllegalArgumentException("Invalid Order")
    return city
}


// Avoid not-null Assertions !!
//Don't
fun foo(order: Order?): String {
    // avoid yelling !! where every possible. search for better solutions by verifying the variable up front and handle nulls. (quote book)
    return order!!.customer!!.address!!.city ?: throw IllegalArgumentException("Invalid Order")
}


// Avoid if-type Checks
interface Service
class CustomerService : Service {
    fun getCustomer(): String {
        return "getCustomer"
    }
}

//Don't
fun getMetrics(service: Service) {
    // also hold on for if-type-checks
    if (service !is CustomerService) {
        throw IllegalArgumentException("No CustomerService")
    }
    service.getCustomer()
}

//Do
fun getMetrics2(service: Service) {
    //check type, (smart-)cast it and throw exception if the type is not the expected one. all in one expression!
    service as? CustomerService ?: throw IllegalArgumentException("No CustomerService")
    service.getCustomer()
}

fun main(args: Array<String>) {
    try {
        println("ship:")
        println(ship(null))
    } catch (ex: IllegalArgumentException) {
        println(ex.message)
    }

    try {
        println("ship2:")
        println(ship2(null))
    } catch (ex: IllegalArgumentException) {
        println(ex.message)
    }

    try {
        println("foo:")
        println(foo(null))
    } catch (ex: NullPointerException) {
        println(ex.message)
    }
}