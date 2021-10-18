package ru.damrin.bmp.domain;


import ru.damrin.bmp.dto.UserAddressDto;

import javax.persistence.*;

@Entity
@Table
public class UserAddress {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column
    //@OneToOne
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private long userId;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private int postalCode;

    private String country;

    private int telephone;

    private int mobile;

    public UserAddress() {
    }

    public UserAddress(int id, long userId, String addressLine1,
                       String addressLine2, String city, int postalCode,
                       String country, int telephone, int mobile) {
        this.id = id;
        this.userId = userId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public UserAddress(String addressLine1, String addressLine2,
                       String city, int postalCode, String country,
                       int telephone, int mobile) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public UserAddressDto userAddressToDto() {
        return new UserAddressDto(addressLine1, addressLine2, city,
                postalCode, country, telephone, mobile);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
