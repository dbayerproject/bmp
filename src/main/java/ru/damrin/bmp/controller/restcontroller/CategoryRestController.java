package ru.damrin.bmp.controller.restcontroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.dto.CategoryDTO;
import ru.damrin.bmp.service.CategoryService;

import java.util.List;

@RestController
@Api(value = "Category resource REST endpoins", description = "Show category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Returns all categories")
        @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> allCategories() {
       return ResponseEntity.ok().body(categoryService.findAllDto());
    }

    @ApiOperation(value = "Returns your category")
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> oneCategory(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create all categories")
    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> newCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.addCategory(categoryDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Create your categories")
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.updateCategory(id, categoryDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete category")
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}