package ru.damrin.bmp.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.dto.CategoryDTO;
import ru.damrin.bmp.service.CategoryService;

import java.util.List;

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> allCategories() {
        return ResponseEntity.ok().body(categoryService.findAllDto());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> oneCategory(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> newCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.addCategory(categoryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO){
       return new ResponseEntity<>(categoryService.updateCategory(id, categoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
