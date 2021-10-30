package ru.damrin.bmp.repository;

import ru.damrin.bmp.domain.Role;

import java.util.Set;

public interface CustomRoleRepository {

    Set<Role> findAll();
    void saveRole(Role role);
    void update(Role role);
    void deleteRole(Role role);
    Role findByRole(String role);
}

