package ru.damrin.bmp.dto;


import ru.damrin.bmp.domain.User;


public class UserDTO {

    private int id;
    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String telephone;


    public UserDTO() {
    }


    public UserDTO(int id, String username, String password, String email, String firstName, String lastName, String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public UserDTO(String username, String password, String email, String firstName, String lastName, String telephone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public User toEntity() {
        return new User(username, password, email, firstName, lastName, telephone);
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}