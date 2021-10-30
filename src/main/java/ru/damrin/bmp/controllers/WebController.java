package ru.damrin.bmp.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.damrin.bmp.domain.Role;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.dto.UserDTO;
import ru.damrin.bmp.service.interfaces.RoleService;
import ru.damrin.bmp.service.interfaces.UserService;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
