package com.example.inventory.presentation.rest;

import com.example.inventory.business.dto.ProductDto;
import com.example.inventory.business.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("products/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable("categoryId") Long categoryId){
        return productService.getProductsByCategory(categoryId);
    }
    @GetMapping("product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId){
        return productService.getProductById(productId);
    }
}
