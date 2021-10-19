package ru.damrin.bmp.service;

import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.dto.UserDTO;


public interface UserService {

    User findById(int id);

    User updateUsername(UserDTO userDTO, String username);

    User updateUserPassword(UserDTO user, String password);

    User updateUserFirstName(UserDTO user, String firstName);

    User updateUserLastName(UserDTO user, String lastName);

    User updateUserTelephone(UserDTO user, int telephone);
}
