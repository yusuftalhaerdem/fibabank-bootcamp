package com.example.inventory.business.service.implementations;

import com.example.inventory.business.dto.CategoryDto;
import com.example.inventory.business.service.CategoryService;
import com.example.inventory.data.entity.Category;
import com.example.inventory.data.repository.CategoryRepository;
import com.example.inventory.util.DtoEntityTransitions;
import com.example.inventory.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<List<CategoryDto>> getCategories(){
        Iterable<Category> categoryIterable = categoryRepository.findAll();

        List<CategoryDto> categoryList = DtoEntityTransitions.iterableCategoryListToDtoList(categoryIterable);

        ResponseBuilder<List<CategoryDto>> responseBuilder = new ResponseBuilder<>(categoryList);
        return responseBuilder.build();
    }
    public ResponseEntity<CategoryDto> addCategory(String categoryName){
        Category category = new Category(categoryName);
        categoryRepository.save(category);
        ResponseBuilder<CategoryDto> responseBuilder = new ResponseBuilder<>(new CategoryDto(category));
        return responseBuilder.build();
    }
}
