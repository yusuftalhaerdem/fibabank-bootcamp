package com.example.inventory.business.dto;

import com.example.inventory.data.entity.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private Long categoryId;
    private String categoryName;

    public CategoryDto(Category category){
        this.categoryId= category.getCategoryId();
        this.categoryName = category.getCategoryName();
    }
}
