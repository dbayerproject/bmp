package ru.damrin.bmp.dto;

import ru.damrin.bmp.domain.User;


public class UserDTO {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private int telephone;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstName, String lastName, int telephone) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public User toEntity() {
        return new User(username, password, firstName, lastName, telephone);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
