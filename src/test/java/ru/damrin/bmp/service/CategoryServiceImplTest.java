package ru.damrin.bmp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.damrin.bmp.domain.Category;
import ru.damrin.bmp.dto.CategoryDTO;
import ru.damrin.bmp.exceptions.CategoryNotFoundException;
import ru.damrin.bmp.repository.CategoryRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void testFindAllDto() {
        this.categoryService.findAllDto();
        verify(this.categoryRepository).findAll();
    }

    @Test
    void testFindAllCategories() {
        this.categoryService.findAllCategories();
        verify(this.categoryRepository).findAll();
    }

    @Test
    void testFindOne() {
        Category category = new Category();
        category.setId(1);
        category.setName("Category");
        category.setDescription("The description of the category");
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findById(anyInt())).thenReturn(ofResult);
        CategoryDTO actualResult = this.categoryService.findOne(1);
        assertEquals(1, actualResult.getId());
        assertEquals("Category", actualResult.getName());
        assertEquals("The description of the category", actualResult.getDescription());
        verify(this.categoryRepository).findById(anyInt());
    }

    @Test
    void testFindOneThrowsException() {
        when(this.categoryRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(CategoryNotFoundException.class, () -> this.categoryService.findOne(1));
        verify(this.categoryRepository).findById((anyInt()));
    }

    @Test
    void testAddCategory() {
        Category category = new Category();
        category.setId(1);
        category.setName("Category");
        category.setDescription("The description of the category");
        when(this.categoryRepository.save(any())).thenReturn(category);
        CategoryDTO actualResult = this.categoryService.addCategory(category.toCategoryDTO());
        assertEquals(1, actualResult.getId());
        assertEquals("Category", actualResult.getName());
        assertEquals("The description of the category", actualResult.getDescription());
        verify(this.categoryRepository).save(any());
    }

    @Test
    void testDeleteCategory() {
        this.categoryService.deleteCategory(1);
        verify(this.categoryRepository).deleteById(any());
        assertTrue(this.categoryService.findAllCategories().isEmpty());
    }

    @Test
    void testUpdateCategory() {
        Category category = new Category();
        category.setId(1);
        category.setName("Category");
        category.setDescription("The description of the category");
        when(this.categoryRepository.save(any())).thenReturn(category);
        CategoryDTO actualResult = this.categoryService.updateCategory(1, category.toCategoryDTO());
        assertEquals(1, actualResult.getId());
        assertEquals("Category", actualResult.getName());
        assertEquals("The description of the category", actualResult.getDescription());
        verify(this.categoryRepository).save(any());
    }

    @Test
    void testFindByCategoryName() {
        Category category = new Category();
        category.setId(1);
        category.setName("Category");
        category.setDescription("The description of the category");
        when(this.categoryRepository.findByName(any())).thenReturn(category);
        CategoryDTO actualResult = this.categoryService.findByCategoryName("Category");
        assertEquals(1, actualResult.getId());
        assertEquals("Category", actualResult.getName());
        assertEquals("The description of the category", actualResult.getDescription());
        verify(this.categoryRepository).findByName(any());
    }

}
