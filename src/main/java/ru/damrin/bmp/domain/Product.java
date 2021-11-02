package ru.damrin.bmp.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import ru.damrin.bmp.dto.ProductDTO;

import javax.persistence.*;

@Entity
@Table
@ApiModel(description = "Product has name, sky etc...")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    private String name;
    private String description;
    private String sku;
    private Double price;

    public Product() {
    }

    public Product(Integer id, String name, String description, String sku, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.price = price;
    }


    public Product(String name, String description, String sku, Double price) {
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.price = price;
    }

    public ProductDTO toDTO() {
        return new ProductDTO(id, name, description, sku, price);
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

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
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

    public Integer getId() {
        return id;
    }

}
