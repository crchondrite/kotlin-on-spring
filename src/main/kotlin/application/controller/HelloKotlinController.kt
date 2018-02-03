package application.controller

import application.entity.GreetingJava
import application.entity.GreetingKotlin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloKotlinController {

    @GetMapping("/hello/kotlin")
    fun hello(@RequestParam(value = "name", defaultValue = "Mr. Kotlin") name: String) =
        // 同モジュール内のLombok / Javaクラスを読み込むとコンパイルの都合で失敗する
        // https://discuss.kotlinlang.org/t/kotlin-java-lombok-interop/1442/2
        // https://devlog.grim3lt.org/2016/08/java-kotlin-lonbok-private.html
        // GreetingJava(name, "Kotlin")
        GreetingKotlin(name, "Kotlin")
}