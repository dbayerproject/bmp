package ru.damrin.bmp.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.damrin.bmp.dto.ProductDTO;
import ru.damrin.bmp.domain.Product;
import ru.damrin.bmp.service.ProductService;

import java.util.List;

@Api(value = "Show products", description = "Show products")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Returns all products")
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        System.out.println("А когда тест запускаем");
        return ResponseEntity.ok().body(productService.getProductList());
    }

    @ApiOperation(value = "Returns one product")
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> show(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create product")
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        System.out.println("when working Post method/create");
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.OK);
}

    @ApiOperation(value = "Update  product")
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable Integer id) {
        return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete product")
    @DeleteMapping("/product/{id}")
    public ResponseEntity<ProductDTO> deleteUser(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}