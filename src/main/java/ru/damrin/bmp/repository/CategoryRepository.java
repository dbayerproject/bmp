package ru.damrin.bmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.damrin.bmp.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByName(String name);
}
