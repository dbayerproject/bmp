package ru.damrin.bmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.damrin.bmp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
