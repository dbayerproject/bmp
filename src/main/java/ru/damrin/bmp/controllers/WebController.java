package ru.damrin.bmp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.damrin.bmp.dto.UserDTO;


@Controller
public class WebController {


    @GetMapping("/registration")
    public String helloUser(Model model, UserDTO userForm) {
        model.addAttribute("userForm", userForm);
        return "registration";
    }
    @GetMapping("/")
    public String  adminPage(){
        return "admin";
    }
}
