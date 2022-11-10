package com.example.inventory.business.service;

import com.example.inventory.business.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<ProductDto>> getProductsByCategory(Long categoryId);

    ResponseEntity<ProductDto> getProductById(Long productId);

}
