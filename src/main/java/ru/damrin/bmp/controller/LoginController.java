package ru.damrin.bmp.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    // тестовый запрос для проверки авторизации
    @GetMapping("/")
    public String testRestricted(OAuth2AuthenticationToken principal) {
        System.out.println(principal.getPrincipal().getAttributes().get("email"));// достаем е-мейл авторизованного пользователя
        return "you can see this only after authorization!";
    }
}
