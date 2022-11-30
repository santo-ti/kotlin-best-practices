package best.practices

import java.lang.ref.WeakReference

class OtherService {
    fun getCustomer(text: String): String {
        return text
    }
}

//Don't
fun notNull(order: Order?): String {
    // If you get an exception in this line, you won’t be able to tell whether order or customer or address was null.
    val city = order!!.customer!!.address!!.city ?: throw NullPointerException("Invalid Order")
    //...
    //..
    val service = OtherService();
    return service.getCustomer(city)
}

//Do
fun nullSafe(order: Order?): String {
    // Safe call operator will keep the code safe and make sure that NullPointerException will never happen.
    val city = order?.customer?.address?.city
    //or
    val city2 = order?.customer?.address?.city ?: "City Default"
    //or
//    val city3 = order?.customer?.address?.city ?: throw IllegalArgumentException("Invalid Order")
    //...
    //..
    val service = OtherService();
    return service.getCustomer(city.orEmpty())
}

fun main(args: Array<String>) {
//    println(notNull(null))

    try {
        println("notNull:")
        println(notNull(null))
    } catch (ex: NullPointerException) {
        println("Exception: ${ex.message}")
    }

    try {
        println("nullSafe:")
        println(nullSafe(null))
    } catch (ex: Exception) {
        println("Exception: ${ex.message}")
    }
}

class Foo(val name: String)

//Don't
fun notNullList() {
    val list = listOf(Foo("Big"), null, Foo("Small")) //Inferred typed List<Foo?>
    list.filter { it != null }
        .map { it?.name?.uppercase() }
}

//Do
fun nullSafeList() {
    val list = listOf(Foo("Big"), null, Foo("Small")) //Inferred typed List<Foo?>
    list.filterNotNull()
        .map { it.name.uppercase() }
}

//Don't
open class BasePresenter<V> {
    private var weakRef: WeakReference<V>? = null

    val view: V?
        get() = if (weakRef == null) null else weakRef!!.get()

    val isViewAttached: Boolean
        get() = weakRef!= null && weakRef!!.get() != null
}

//Do
open class BasePresenter2<V> {
    private var weakRef: WeakReference<V>? = null

    val view: V?
        get() = weakRef?.get()

    val isViewAttached: Boolean
        get() = (view != null)
}