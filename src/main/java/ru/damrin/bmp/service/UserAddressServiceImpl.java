package ru.damrin.bmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.damrin.bmp.domain.UserAddress;
import ru.damrin.bmp.exceptions.UserNotFoundException;
import ru.damrin.bmp.repository.UserAddressRepository;

import java.util.Optional;


@Service
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    @Autowired
    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddress findById(int id) {
        return (userAddressRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public String findAddressLine1(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getAddressLine1();
    }

    @Override
    public String updateAddressLine1(int id, String newAddressLine1) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setAddressLine1(newAddressLine1);
        return userAddress.getAddressLine1();
    }

    @Override
    public String findAddressLine2(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getAddressLine2();
    }

    @Override
    public String updateAddressLine2(int id, String newAddressLine2) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setAddressLine1(newAddressLine2);
        return userAddress.getAddressLine2();
    }

    @Override
    public String findCity(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getCity();
    }

    @Override
    public String updateCity(int id, String newCity) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setAddressLine1(newCity);
        return userAddress.getCity();
    }

    @Override
    public int findPostalCode(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getPostalCode();
    }

    @Override
    public int updatePostalCode(int id, int newPostalCode) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setPostalCode(newPostalCode);
        return userAddress.getPostalCode();
    }

    @Override
    public String findCountry(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getCountry();
    }

    @Override
    public String updateCountry(int id, String newCountry) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setAddressLine1(newCountry);
        return userAddress.getCountry();
    }

    @Override
    public int findTelephone(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getTelephone();
    }

    @Override
    public int updateTelephone(int id, int newTelephone) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setTelephone(newTelephone);
        return userAddress.getTelephone();
    }

    @Override
    public void deleteTelephone(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setEmptyTelephone();
        userAddressRepository.save(userAddress);
    }

    @Override
    public int findMobile(int id) {
        UserAddress userAddress = userAddressRepository.getById(id);
        return userAddress.getMobile();

    }

    @Override
    public int updateMobile(int id, int newMobile) {
        UserAddress userAddress = userAddressRepository.getById(id);
        userAddress.setMobile(newMobile);
        return userAddress.getMobile();
    }
}
