package com.example.inventory.business.service;

import com.example.inventory.business.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<List<CategoryDto>> getCategories();

    ResponseEntity<CategoryDto> addCategory(String categoryName);
}
