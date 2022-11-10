package com.example.inventory.business.service;

import com.example.inventory.business.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void getCategories() {
        ResponseEntity<List<CategoryDto>> response = categoryService.getCategories();
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while fetching categories");
    }

    @Test
    void addCategory() {
        ResponseEntity<CategoryDto> response = categoryService.addCategory("category test");
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while added category");
    }
}