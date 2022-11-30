package best.practices

// With data classes, writing immutable value objects is so easy.
// Even for value objects containing only a single property.
// So there is no excuse for not using value objects anymore!

// Don't
//without value object:
fun send(target: String){}

// Do
//expressive, readable, safe
fun send(target: EmailAddress){}
// Or
fun send(target: EmailAddress2){}

//with value object:
data class EmailAddress(val value: String)

// Even better (Kotlin 1.3): Since Kotlin 1.3, we should use inline classes for value objects
inline class EmailAddress2(val value: String)

// is not instantiated in the compiled code because the underlying value is inlined,
// relieving us from the performance penalties associated with instantiation.