package com.example.shopping.business.services;

import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import org.springframework.http.ResponseEntity;

public interface ShoppingService {

    //ResponseEntity<Long> createCart(String customerName);
    ResponseEntity<String> updateCartProduct(CartProductDto cartProductDto);

    ResponseEntity<String> removeProductFromCart(Long cartId, Long productId);

    ResponseEntity<CartDto> findCart(String customerName);

    //ResponseEntity<String> checkoutCart(Long cartId);

}
