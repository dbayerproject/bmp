package ru.damrin.bmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.dto.UserDTO;
import ru.damrin.bmp.exceptions.UserNotFoundException;
import ru.damrin.bmp.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        return (userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public User updateUsername(UserDTO userDTO, String username) {
        User user = userDTO.toEntity();
        user.setUsername(username);
        return userRepository.save(user);
    }

    @Override
    public User updateUserPassword(UserDTO userDTO, String password) {
        User user = userDTO.toEntity();
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public User updateUserFirstName(UserDTO userDTO, String firstName) {
        User user = userDTO.toEntity();
        userDTO.setFirstName(firstName);
        return userRepository.save(user);
    }

    @Override
    public User updateUserLastName(UserDTO userDTO, String lastName) {
        User user = userDTO.toEntity();
        userDTO.setLastName(lastName);
        return userRepository.save(user);
    }

    @Override
    public User updateUserTelephone(UserDTO userDTO, int telephone) {
        User user = userDTO.toEntity();
        userDTO.setTelephone(telephone);
        return userRepository.save(user);
    }
}
