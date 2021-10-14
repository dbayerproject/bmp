package ru.damrin.bmp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.damrin.bmp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
   public Product findByName(String name);
}
