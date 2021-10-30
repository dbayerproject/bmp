package ru.damrin.bmp.service;


import org.springframework.stereotype.Service;
import ru.damrin.bmp.domain.Role;
import ru.damrin.bmp.repository.CustomRoleRepository;
import ru.damrin.bmp.service.interfaces.RoleService;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final CustomRoleRepository customRoleRepository;

    public RoleServiceImpl(CustomRoleRepository customRoleRepository) {
        this.customRoleRepository = customRoleRepository;
    }

    @Transactional
    @Override
    public boolean add(Role role) {
        Role existedRole = customRoleRepository.findByRole(role.getRole());

        if (existedRole != null){
            return false;
        }
        customRoleRepository.saveRole(role);
        return true;
    }

    @Override
    public Role getById(Long id) {
        return null;
    }

    @Override
    public Role getByName(String name) {
        return customRoleRepository.findByRole(name);
    }

    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public Set<Role> findAll() {
        return customRoleRepository.findAll();
    }
}
