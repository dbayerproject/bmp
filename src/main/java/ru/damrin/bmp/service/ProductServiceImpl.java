package ru.damrin.bmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.damrin.bmp.dao.ProductRepository;
import ru.damrin.bmp.dto.ProductDTO;
import ru.damrin.bmp.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return (productRepository.save(productDTO.toEntity())).toDTO();
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product product = productDTO.toEntity();
        product.setId(id);
        return (productRepository.save(product)).toDTO();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDTO> getProductDTOList() {
        return productRepository.findAll().stream().map(Product::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductByName(String name) {
        return productRepository.findByName(name).toDTO();
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow().toDTO();
    }
}
