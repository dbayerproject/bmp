package ru.damrin.bmp.service;

import ru.damrin.bmp.domain.Category;
import ru.damrin.bmp.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> findAllDto();
    public List<Category> findAllCategories();
    public Category findOne(int id);
    public Category addCategory(CategoryDTO category);
    public void deleteCategory(int id);
    public Category updateCategory(int id, CategoryDTO category);
    public Category findByCategoryName(String name);
}
