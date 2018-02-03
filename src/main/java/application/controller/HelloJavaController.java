package application.controller;

import application.entity.GreetingJava;
import application.service.http.HyperHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloJavaController {

    private final HyperHttpClient httpClient;

    @Autowired
    public HelloJavaController(HyperHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @GetMapping("/hello/java")
    public GreetingJava hello(@RequestParam(value = "name", defaultValue = "Mr. Java") String name) {
        return new GreetingJava(name, "Java");
    }

    @GetMapping("/http/java")
    public String httpJava() {
        return httpClient.hello("java");
    }
}
