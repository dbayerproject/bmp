package ru.damrin.bmp.controller.restcontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.dto.UserDTO;
import ru.damrin.bmp.service.UserService;

@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/username/{id}")
    public ResponseEntity<String> getUsername(@PathVariable int id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user.getUsername(), HttpStatus.OK);
    }

    @PutMapping("/updateUsername/{id}")
    public ResponseEntity<UserDTO> updateUsername(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUsername(userDTO, userDTO.getUsername()).toUserDTO(), HttpStatus.OK);
    }

    @GetMapping("/password/{id}")
    public ResponseEntity<String> getPassword(@PathVariable int id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user.getPassword(), HttpStatus.OK);
    }


    @PutMapping("/updatePassword")
    public ResponseEntity<UserDTO> updatePassword(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUserPassword(userDTO,userDTO.getPassword()).toUserDTO(),
                HttpStatus.OK);
    }

    @GetMapping("/firstName/{id}")
    public ResponseEntity<String> getFirstName(@PathVariable int id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user.getFirstName(), HttpStatus.OK);
    }

    @PutMapping("/updateFirstName")
    public ResponseEntity<UserDTO> updateFirstName(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUserFirstName(userDTO, userDTO.getFirstName()).toUserDTO(),
                HttpStatus.OK);
    }

    @GetMapping("/lastName/{id}")
    public ResponseEntity<String> getLastName(@PathVariable int id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user.getLastName(), HttpStatus.OK);
    }

    @PutMapping("/updateLastName")
    public ResponseEntity<UserDTO> updateLastName(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUserLastName(userDTO, userDTO.getLastName()).toUserDTO(),
                HttpStatus.OK);
    }

    @GetMapping("/telephone/{id}")
    public ResponseEntity<Integer> getTelephone(@PathVariable int id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user.getTelephone(), HttpStatus.OK);
    }

    @PutMapping("/updateTelephone")
    public ResponseEntity<UserDTO> updateTelephone(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.updateUserTelephone(userDTO, userDTO.getTelephone()).toUserDTO(),
                HttpStatus.OK);
    }
}
