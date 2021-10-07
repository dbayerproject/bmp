package ru.damrin.bmp.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.damrin.bmp.common.BaseTimeEntity;
import ru.damrin.bmp.dto.UserDTO;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private int telephone;

    public User() {
    }

    public User(int id, String username, String password, String email, String firstName, String lastName, int telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public User(String username, String password, String firstName, String lastName, int telephone) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }


    public UserDTO toUserDTO(){
        return new UserDTO(username, password, firstName, lastName, telephone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
