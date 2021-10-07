package ru.damrin.bmp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ROLE")
    private String role;

    @ManyToMany(targetEntity = Role.class, mappedBy = "roles")
    @JsonIgnore
    private List<User> users;


    public Role() {
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }


    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    //GrantedAuthority implements
    @Override
    public String getAuthority() {
        return role;
    }
}
