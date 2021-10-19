package ru.damrin.bmp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.model.User;
import ru.damrin.bmp.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/getUsername")
    public ResponseEntity<String> getUsername(@RequestBody User user) {
        return user.getUsername() != null ? ResponseEntity.ok(user.getUsername())
                : ResponseEntity.badRequest().build();
    }

    @PatchMapping("/updateUserPassword")
    public ResponseEntity<User> updatePassword(@RequestBody User user) {
        userService.updateUserPassword(user, user.getPassword());
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/getUserFirstName")
    public ResponseEntity<String> getUserFirstName(@RequestBody User user) {
        return user.getFirstName() != null ? ResponseEntity.ok(user.getFirstName())
                : ResponseEntity.badRequest().build();
    }

    @PatchMapping("/updateUserFirstName")
    public ResponseEntity<User> updateUserFirstName(@RequestBody User user) {
        userService.updateUserFirstName(user, user.getFirstName());
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/getUserLastName")
    public ResponseEntity<String> getUserLastName(@RequestBody User user) {
        return user.getLastName() != null ? ResponseEntity.ok(user.getLastName())
                : ResponseEntity.badRequest().build();
    }
    @PatchMapping("/updateUserLastName")
    public ResponseEntity<User> updateUserLastName(@RequestBody User user) {
        userService.updateUserLastName(user, user.getLastName());
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/getUserTelephone")
    public ResponseEntity<Integer> getUserTelephone(@RequestBody User user) {
        return user.getTelephone() != 0 ? ResponseEntity.ok(user.getTelephone())
                : ResponseEntity.badRequest().build();
    }

    @PatchMapping("/updateUserTelephone")
    public ResponseEntity<User> updateUserTelephone(@RequestBody User user) {
        userService.updateUserTelephone(user, user.getTelephone());
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }
}
