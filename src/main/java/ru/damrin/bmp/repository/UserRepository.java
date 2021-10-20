package ru.damrin.bmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.damrin.bmp.domain.User;


public interface UserRepository  extends JpaRepository<User, Integer>{


}
