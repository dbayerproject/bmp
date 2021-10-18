package ru.damrin.bmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.damrin.bmp.domain.UserAddress;


@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}
