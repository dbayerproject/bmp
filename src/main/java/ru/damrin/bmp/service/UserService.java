package ru.damrin.bmp.service;

import ru.damrin.bmp.model.User;

public interface UserService {
    User findByEmail(String email);
}
