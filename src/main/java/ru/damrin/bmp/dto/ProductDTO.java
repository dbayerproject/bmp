package ru.damrin.bmp.dto;

import ru.damrin.bmp.domain.Product;
import springfox.documentation.annotations.ApiIgnore;


public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private String sku;
    private Double price;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, String description, String sku, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.price = price;
    }

    public Product toEntity() {
        return new Product (name, description, sku, price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
