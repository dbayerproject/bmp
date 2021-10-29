package ru.damrin.bmp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


    private final RoleService roleService;
    private final UserService userService;
    private  final PasswordEncoder passwordEncoder;

    public WebController(RoleService roleService, UserService userService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String helloAdmin() {

        if (roleService.findAll().isEmpty()) {
            roleService.add(new Role("ROLE_ADMIN"));
        }
        Set<Role> adminRoles = Stream.of(roleService.getByName("ROLE_ADMIN")).collect(Collectors.toSet());
        User admin = new User("admin", "admin", "admin@admin.com", "Admin", "Adminov", "88002005555", adminRoles);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        userService.saveUser(admin);
        return "login";
    }

    @GetMapping("/registration")
    public String helloUser(Model model, UserDTO userForm) {
        model.addAttribute("userForm", userForm);
        return "registration";
    }
}
