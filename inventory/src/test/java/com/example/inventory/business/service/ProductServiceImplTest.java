package com.example.inventory.business.service;

import com.example.inventory.business.dto.ProductDto;
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
class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    void getProductsByCategory() {
        ResponseEntity<List<ProductDto>> response = productService.getProductsByCategory(4L);
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while fetching products by category id");
    }

    @Test
    void getProductById() {
        ResponseEntity<ProductDto> response = productService.getProductById(3L);
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while fetching product by id");
    }
}