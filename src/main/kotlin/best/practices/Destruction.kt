package best.practices

//destruction useful for

//a) returning multiple values from a function. define an own data class
data class ServiceConfig(val host: String, val port: Int)

fun createServiceConfig(): ServiceConfig {
    return ServiceConfig("api.domain.io", 9389)
}

//Do
fun bla() {
    val (host, port) = createServiceConfig()
}

//b) iterate over maps
//Do
fun foo() {
    val map = mapOf("api.domain.io" to 9389, "localhost" to 8080)
    for ((host, port) in map) {
        //...
    }
}

