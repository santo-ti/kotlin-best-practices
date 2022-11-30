package best.practices

import org.apache.commons.dbcp2.BasicDataSource
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import java.util.concurrent.TimeUnit

//apply() is often useful when dealing with Java libraries in Kotlin.

//Don't
fun blub() {
    val dataSource = BasicDataSource()
    dataSource.driverClassName = "com.mysql.jdbc.Driver"
    dataSource.url = "jdbc:mysql://domain:3309/db"
    dataSource.username = "username"
    dataSource.password = "password"
    dataSource.maxTotal = 40
    dataSource.maxIdle = 40
    dataSource.minIdle = 4
}

// Do
val dataSource = BasicDataSource().apply {
    driverClassName = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://domain:3309/db"
    username = "username"
    password = "password"
    maxTotal = 40
    maxIdle = 40
    minIdle = 4
}

// think twice before you define a init block/constructor body
// (first, named and default argument can help)
// second, you can refer to primary constructor para in property initializers (and not only in the init block)
// apply() can help to group initialization code and get along with a single expression.

// Don't
class UsersClient(baseUrl: String, appName: String) {
    private val usersUrl: String
    private val httpClient: HttpClient

    init {
        usersUrl = "$baseUrl/users"
        val builder = HttpClientBuilder.create()
        builder.setUserAgent(appName)
        builder.setConnectionTimeToLive(10, TimeUnit.SECONDS)
        httpClient = builder.build()
    }

    fun getUsers() {
        //call service using httpClient and usersUrl
    }
}

// Do
class UsersClient2(baseUrl: String, appName: String) {
    private val usersUrl = "$baseUrl/users"

    private val httpClient = HttpClientBuilder.create().apply {
        setUserAgent(appName)
        setConnectionTimeToLive(10, TimeUnit.SECONDS)
    }.build()

    //or
    private val httpClient2 = HttpClientBuilder.create()
        .setUserAgent(appName)
        .setConnectionTimeToLive(10, TimeUnit.SECONDS)
        .build()

    fun getUsers() {
        //call service using httpClient and usersUrl
    }
}
//- `apply()` can help to group initialization code and get along with a single expression.