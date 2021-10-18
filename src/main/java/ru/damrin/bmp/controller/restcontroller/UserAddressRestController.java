package ru.damrin.bmp.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.service.UserAddressService;

@RestController
public class UserAddressRestController {

    private final UserAddressService userAddressService;

    @Autowired
    public UserAddressRestController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping("/userAddress/userAddressLine1/{id}")
    public ResponseEntity<String> getUserAddressLine1(@PathVariable int id) {
        String addressLine1 = userAddressService.findAddressLine1(id);
        return new ResponseEntity<>(addressLine1, HttpStatus.OK);
    }
    @PatchMapping("/userAddress/userAddressLine1/update/{id}")
    public ResponseEntity<String> updateUserAddressLine1(@PathVariable int id)  {
        String addressLine1 = userAddressService.findAddressLine1(id);
        return new ResponseEntity<>(userAddressService
                .updateAddressLine1(id, addressLine1),HttpStatus.OK);
    }




    /*String findAddressLine2(int id);
    String updateAddressLine2(int id, String addressLine2);
    String findCity(int id);
    String updateCity(int id, String city);
    int findPostalCode(int id);
    int updatePostalCode(int id, int postalCode);
    String findCountry(int id);
    String updateCountry(int id, String country);
    int findTelephone(int id);
    int updateTelephone(int id, int telephone);
    void deleteTelephone(int id);
    int findMobile(int id);
    int updateMobile(int id, int mobile)*/
}
