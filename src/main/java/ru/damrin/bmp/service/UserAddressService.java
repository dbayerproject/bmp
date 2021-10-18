package ru.damrin.bmp.service;

public interface UserAddressService {
    String findAddressLine1(int id);
    String updateAddressLine1(int id, String addressLine1);
    String findAddressLine2(int id);
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
    int updateMobile(int id, int mobile);







}
