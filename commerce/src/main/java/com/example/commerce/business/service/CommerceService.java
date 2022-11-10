package com.example.commerce.business.service;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommerceService {
    ResponseEntity<List<CategoryDto>> getCategories();
    ResponseEntity<List<ProductDto>> getProductsByCategory(Long categoryId);
    ResponseEntity<ProductDto> getProductById(Long productId);
    ResponseEntity<Long> createCart();
    ResponseEntity<String> addProductToCart(CartProductDto cartProductDto);
    ResponseEntity<String> removeProductFromCart(Long cartId, Long productId);
    ResponseEntity<String> checkoutCart(Long cartId);
    ResponseEntity<CartDto> findCart();


}
