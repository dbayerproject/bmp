package ru.damrin.bmp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.damrin.bmp.dao.ProductRepository;
import ru.damrin.bmp.dto.ProductDTO;
import ru.damrin.bmp.domain.Product;
import ru.damrin.bmp.service.ProductServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Book");
        product.setDesc("Interesting");
        product.setSku("dontknow");
        product.setPrice(35.0);
        when(this.productRepository.save(any())).thenReturn(product);
        ProductDTO result = this.productService.createProduct(product.toDTO());
        assertEquals(1, result.getId());
        assertEquals("Book", result.getName());
        assertEquals("Interesting", result.getDescription());
        assertEquals("dontknow", result.getSku());
        assertEquals(35.0, result.getPrice());
        verify(this.productRepository).save(any());
    }


    @Test
    void testGetProductDTOList() {
        this.productService.getProductDTOList();
        verify(this.productRepository).findAll();
    }

    @Test
    void testGetProductList() {
        this.productService.getProductList();
        verify(this.productRepository).findAll();
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1);
        product.setName("Book");
        product.setDesc("Interesting");
        product.setSku("dontknow");
        product.setPrice(35.0);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findById(anyInt())).thenReturn(ofResult);
        ProductDTO result = this.productService.getProductById(1);
        assertEquals(1, result.getId());
        assertEquals("Book", result.getName());
        assertEquals("Interesting", result.getDescription());
        assertEquals("dontknow", result.getSku());
        assertEquals(35.0, result.getPrice());
        verify(this.productRepository).findById(anyInt());
    }


    @Test
    void testDeleteProduct() {
        this.productService.deleteProduct(1);
        verify(this.productRepository).deleteById(any());
        assertTrue(this.productService.getProductList().isEmpty());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Book");
        product.setDesc("Interesting");
        product.setSku("dontknow");
        product.setPrice(35.0);
        when(this.productRepository.save(any())).thenReturn(product);
        ProductDTO result = this.productService.updateProduct(1, product.toDTO());
        assertEquals(1, result.getId());
        assertEquals("Book", result.getName());
        assertEquals("Interesting", result.getDescription());
        assertEquals("dontknow", result.getSku());
        assertEquals(35.0, result.getPrice());
        verify(this.productRepository).save(any());
    }


    @Test
    void testGetProductByName() {
        Product product = new Product();
        product.setId(1);
        product.setName("Book");
        product.setDesc("Interesting");
        product.setSku("dontknow");
        product.setPrice(35.0);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findById(anyInt())).thenReturn(ofResult);
        ProductDTO result = this.productService.getProductByName("Book");
        assertEquals(1, result.getId());
        assertEquals("Book", result.getName());
        assertEquals("Interesting", result.getDescription());
        assertEquals("dontknow", result.getSku());
        assertEquals(35.0, result.getPrice());
        verify(this.productRepository).findById(anyInt());
    }
}
