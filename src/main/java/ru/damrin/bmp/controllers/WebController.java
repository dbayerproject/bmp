package ru.damrin.bmp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Через конфиги редиректить не хочет. пришлось слепить контроллер.

@RestController
public class WebController {


    @GetMapping("/hello")
    public ResponseEntity<String> helloAdmin() {
        String body = "Hello, Admin";
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("/hellouser")
    public ResponseEntity<String> helloUser() {
        String body = "Hello, User";
        return ResponseEntity.ok().body(body);
    }
}
