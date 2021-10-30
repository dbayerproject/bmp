package ru.damrin.bmp.service.interfaces;

import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.dto.UserDTO;

import java.util.List;


public interface UserService {

    public List<UserDTO> findAllDto();

    User findById(int id);

    User findByUsername(String username);


    User saveUser(User user);

    void deleteUser(int id);

    User enPass(UserDTO userDTO);
}