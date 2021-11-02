package ru.damrin.bmp.service.interfaces;

import ru.damrin.bmp.domain.Role;

import java.util.Set;

public interface RoleService {
    boolean add(Role role);

    Role getById(Long id);

    Role getByName(String name);

    boolean update(Role role);

    Set<Role> findAll();


}
