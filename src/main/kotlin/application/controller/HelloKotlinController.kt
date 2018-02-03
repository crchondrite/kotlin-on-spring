package application.controller

import application.entity.GreetingKotlin
import application.service.http.HyperHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
// https://stackoverflow.com/questions/35479631/how-to-use-spring-annotations-like-autowired-in-kotlin
// kotlinでField injectionしようとするとlateinit varで定義する必要があり、イケてない
class HelloKotlinController @Autowired constructor(
    val httpClient: HyperHttpClient
) {

    @GetMapping("/hello/kotlin")
    fun hello(@RequestParam(value = "name", defaultValue = "Mr. Kotlin") name: String) =
        // 同モジュール内のLombok / Javaクラスを読み込むとコンパイルの都合で失敗する
        // https://discuss.kotlinlang.org/t/kotlin-java-lombok-interop/1442/2
        // https://devlog.grim3lt.org/2016/08/java-kotlin-lonbok-private.html
        // GreetingJava(name, "Kotlin")
        GreetingKotlin(name, "Kotlin")

    @GetMapping("/http/kotlin")
    fun httpKotlin(): String = httpClient.hello("kotlin")
}