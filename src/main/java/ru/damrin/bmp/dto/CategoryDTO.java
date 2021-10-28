package ru.damrin.bmp.dto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import ru.damrin.bmp.domain.Category;
import springfox.documentation.annotations.ApiIgnore;



public class CategoryDTO {
    private int id;
    private String name;
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category toEntity() {
        return new Category(name, description);
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
}
