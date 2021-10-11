package ru.damrin.bmp.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "TELEPHONE")
    private int telephone;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "MODIFIED_AT")
    private Date modifiedAt;

    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "ROLEID"))
    @JsonIgnore
    private List<Role> roles;

    public User() {
    }

    public User(int id, String username, String password, String email, String firstname, String lastname, int telephone, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    //getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) { this.username = username; }
    @Override
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) { this.password = password;}
    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}

    public String getFirstname() {return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname;}

    public String getLastname() { return lastname;}
    public void setLastname(String lastname) { this.lastname = lastname;}

    public int getTelephone() { return telephone;}
    public void setTelephone(int telephone) { this.telephone = telephone;}

    public Date getCreatedAt() { return createdAt;}
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt;}

    public Date getModifiedAt() {return modifiedAt;}
    public void setModifiedAt(Date modifiedAt) {this.modifiedAt = modifiedAt;}

    //UserDetails implements
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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
