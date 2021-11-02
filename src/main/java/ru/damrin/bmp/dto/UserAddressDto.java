package ru.damrin.bmp.dto;

import ru.damrin.bmp.domain.UserAddress;

public class UserAddressDto {

    private String addressLine1;

    private String addressLine2;

    private String city;

    private int postalCode;

    private String country;

    private int telephone;

    private int mobile;

    public UserAddressDto() {
    }

    public UserAddressDto(String addressLine1, String addressLine2, String city,
                          int postalCode, String country, int telephone, int mobile) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public UserAddress toEntity(String addressLine1, String addressLine2,
                                String city, int postalCode,
                                String country, int telephone, int mobile) {
        return new UserAddress(addressLine1, addressLine2, city, postalCode, country, telephone, mobile);
    }
}
