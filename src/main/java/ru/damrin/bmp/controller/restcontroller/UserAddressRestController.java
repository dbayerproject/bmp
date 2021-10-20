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
    public ResponseEntity<String> updateUserAddressLine1(@PathVariable int id) {
        String addressLine1 = userAddressService.findAddressLine1(id);
        return new ResponseEntity<>(userAddressService
                .updateAddressLine1(id, addressLine1), HttpStatus.OK);
    }

    @GetMapping("/userAddress/userAddressLine2/{id}")
    public ResponseEntity<String> getUserAddressLine2(@PathVariable int id) {
        String addressLine2 = userAddressService.findAddressLine2(id);
        return new ResponseEntity<>(addressLine2, HttpStatus.OK);
    }

    @PatchMapping("/userAddress/userAddressLine2/update/{id}")
    public ResponseEntity<String> updateUserAddressLine2(@PathVariable int id) {
        String addressLine2 = userAddressService.findAddressLine2(id);
        return new ResponseEntity<>(userAddressService
                .updateAddressLine2(id, addressLine2), HttpStatus.OK);
    }

    @GetMapping("/userAddress/city/{id}")
    public ResponseEntity<String> getUserCity(@PathVariable int id) {
        String userCity = userAddressService.findCity(id);
        return new ResponseEntity<>(userCity, HttpStatus.OK);
    }

    @PatchMapping("/userAddress/city/update/{id}")
    public ResponseEntity<String> updateUserCity(@PathVariable int id) {
        String userCity = userAddressService.findCity(id);
        return new ResponseEntity<>(userAddressService
                .updateCity(id, userCity), HttpStatus.OK);
    }

    @GetMapping("/userAddress/postalCode/{id}")
    public ResponseEntity<Integer> getPostalCode(@PathVariable int id) {
        int postalCode = userAddressService.findPostalCode(id);
        return new ResponseEntity<>(postalCode, HttpStatus.OK);
    }

    @PatchMapping("/userAddress/postalCode/update/{id}")
    public ResponseEntity<Integer> updatePostalCode(@PathVariable int id) {
        int postalCode = userAddressService.findPostalCode(id);
        return new ResponseEntity<>(userAddressService
                .updatePostalCode(id, postalCode), HttpStatus.OK);
    }

    @GetMapping("/userAddress/country/{id}")
    public ResponseEntity<String> getUserCountry(@PathVariable int id) {
        String userCountry = userAddressService.findCountry(id);
        return new ResponseEntity<>(userCountry, HttpStatus.OK);
    }

    @PatchMapping("/userAddress/country/update/{id}")
    public ResponseEntity<String> updateUserCountry(@PathVariable int id) {
        String userCountry = userAddressService.findCountry(id);
        return new ResponseEntity<>(userAddressService
                .updateCountry(id, userCountry), HttpStatus.OK);
    }

    @GetMapping("/userAddress/telephone/{id}")
    public ResponseEntity<Integer> getTelephone(@PathVariable int id) {
        int telephone = userAddressService.findTelephone(id);
        return new ResponseEntity<>(telephone, HttpStatus.OK);
    }

    @PatchMapping("/userAddress/telephone/update/{id}")
    public ResponseEntity<Integer> updateTelephone(@PathVariable int id) {
        int telephone = userAddressService.findTelephone(id);
        return new ResponseEntity<>(userAddressService
                .updateTelephone(id, telephone), HttpStatus.OK);
    }

    @PatchMapping("/userAddress/telephone/delete/{id}")
    public ResponseEntity<Void> deleteTelephone(@PathVariable int id) {
        userAddressService.deleteTelephone(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/userAddress/mobile/{id}")
    public ResponseEntity<Integer> getMobile(@PathVariable int id) {
        int mobile = userAddressService.findMobile(id);
        return new ResponseEntity<>(mobile, HttpStatus.OK);
    }

    @PatchMapping("/userAddress/telephone/update/{id}")
    public ResponseEntity<Integer> updateMobile(@PathVariable int id) {
        int mobile = userAddressService.findMobile(id);
        return new ResponseEntity<>(userAddressService
                .updateMobile(id, mobile), HttpStatus.OK);
    }
}
