package ru.damrin.bmp.service;

import ru.damrin.bmp.domain.Category;
import ru.damrin.bmp.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> findAllDto();
    public List<Category> findAllCategories();
    public CategoryDTO findOne(int id);
    public CategoryDTO addCategory(CategoryDTO category);
    public void deleteCategory(int id);
    public CategoryDTO updateCategory(int id, CategoryDTO category);
    public CategoryDTO findByCategoryName(String name);
}
