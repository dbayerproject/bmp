package ru.damrin.bmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.damrin.bmp.dto.CategoryDTO;
import ru.damrin.bmp.exceptions.CategoryNotFoundException;
import ru.damrin.bmp.domain.Category;
import ru.damrin.bmp.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAllDto() {
        return categoryRepository.findAll().stream().map(Category::toCategoryDTO).collect(Collectors.toList());
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDTO findOne(int id) {
        return (categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id))).toCategoryDTO();
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        return (categoryRepository.save(categoryDTO.toEntity())).toCategoryDTO();
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
        Category category = categoryDTO.toEntity();
        category.setId(id);
        return (categoryRepository.save(category)).toCategoryDTO();
    }

    @Override
    public CategoryDTO findByCategoryName(String name) {
        return (categoryRepository.findByName(name)).toCategoryDTO();
    }
}
