package ru.damrin.bmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ru.damrin.bmp.controllers.WebController;

@SpringBootApplication
@EnableJpaAuditing
public class BmpApplication {



    public static void main(String[] args) {
        SpringApplication.run(BmpApplication.class, args);
    }

}
