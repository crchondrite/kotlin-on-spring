package application.controller;

import application.entity.GreetingJava;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloJavaController {
    @GetMapping("/hello/java")
    public GreetingJava hello(@RequestParam(value = "name", defaultValue = "Mr. Java") String name) {
        return new GreetingJava(name, "Java");
    }
}
