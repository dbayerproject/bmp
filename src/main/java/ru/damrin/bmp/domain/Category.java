package ru.damrin.bmp.domain;


import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ru.damrin.bmp.common.BaseTimeEntity;
import ru.damrin.bmp.dto.CategoryDTO;

import javax.persistence.*;


@Entity
@Table(name = "product_category")
@SQLDelete(sql = "UPDATE product_category SET deleted = true WHERE category_id = ?")
@Where(clause = "deleted=false")
@ApiModel(value = "Category", description = "Category has name, sky etc...")
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;
    private String name;
    private String description;
    private boolean deleted = Boolean.FALSE;

    public Category () {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryDTO toCategoryDTO() {
        return new CategoryDTO(id, name, description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
