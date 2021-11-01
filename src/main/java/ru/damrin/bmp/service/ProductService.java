package ru.damrin.bmp.service;

import org.springframework.stereotype.Service;
import ru.damrin.bmp.dto.ProductDTO;
import ru.damrin.bmp.domain.Product;

import java.util.List;

@Service
public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Integer id, ProductDTO productDTO);

    void deleteProduct(Integer id);

    List<Product> getProductList();

    List<ProductDTO> getProductDTOList();

    ProductDTO getProductByName(String name);

    ProductDTO getProductById(Integer id);
}
