package ru.damrin.bmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.damrin.bmp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
