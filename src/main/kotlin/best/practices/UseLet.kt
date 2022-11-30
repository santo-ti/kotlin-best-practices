package best.practices

fun findOrder(): Order? {
    return null
}

fun dun(customer: Customer?) {
}

// Don't
fun handle() {
    val order: Order? = findOrder()
    if (order != null) {
        dun(order.customer)
    }
}

// Do
fun handle2() {
    // with let(), there is no need for an extra variable
    // can write as one expression
    findOrder()?.let { dun(it.customer) }
    //or
    findOrder()?.customer?.let(::dun)
}