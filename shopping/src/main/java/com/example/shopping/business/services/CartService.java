package com.example.shopping.business.services;

import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<Long> createCart(String customerName);

    ResponseEntity<String> checkoutCart(Long cartId);

}
