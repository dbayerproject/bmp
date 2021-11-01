package ru.damrin.bmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.damrin.bmp.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByName(String name);
}
