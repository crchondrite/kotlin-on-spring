package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Java側に起動クラスがある場合、scanBasePackagesを定義してあげないとcomponent scanしてくれないっぽい
@SpringBootApplication(scanBasePackages = {"application"})
public class KotlinOnSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KotlinOnSpringApplication.class, args);
    }
}
