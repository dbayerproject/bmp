package ru.damrin.bmp.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.dto.UserDTO;
import ru.damrin.bmp.service.interfaces.UserService;

import java.util.List;


@RestController
@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class UserRestController {

    private final UserService userService;


    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;

    }


    @GetMapping("alluser")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAllDto());
    }


    @PostMapping("reg")
    public ResponseEntity<UserDTO> saveUser(UserDTO userDTO) {
        userService.enPass(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @PostMapping("save")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        userService.enPass(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.findById(id));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}