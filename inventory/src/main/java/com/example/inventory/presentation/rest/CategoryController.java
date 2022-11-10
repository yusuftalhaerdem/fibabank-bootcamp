package com.example.inventory.presentation.rest;

import com.example.inventory.business.dto.CategoryDto;
import com.example.inventory.business.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("addCategory/{category_name}")
    public ResponseEntity<CategoryDto> addCategory(@PathVariable("category_name") String categoryName){
        return categoryService.addCategory(categoryName);
    }
}
