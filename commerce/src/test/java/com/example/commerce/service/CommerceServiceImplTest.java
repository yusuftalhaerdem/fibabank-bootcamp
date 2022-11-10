package com.example.commerce.service;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.service.CommerceService;
import com.example.commerce.business.service.CommerceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CommerceServiceImplTest {

    @Autowired
    CommerceService commerceService ;

    @BeforeEach
    void setUp() {
    }



    @Test
    void getCategories() {
        commerceService.getCategories();
    }

    @Test
    void getProductsByCategory() {
        commerceService.getProductsByCategory(3L);
    }

    @Test
    void getProductById() {
        commerceService.getProductById(2L);
    }

    @Test
    void createCart() {
        commerceService.createCart();
    }

    @Test
    void addProductToCart() {
        CartProductDto cartProductDto = new CartProductDto(6L,2L,4L,2,240.0,480.0,null);
        ResponseEntity<String> response = commerceService.addProductToCart(cartProductDto);
        assertEquals(response.getStatusCode(),HttpStatus.OK,"There is an error.");
    }

    @Test
    void removeProductFromCart()  {

        ResponseEntity<String> response = commerceService.removeProductFromCart(2L,4L);
        assertEquals(response.getStatusCode(), HttpStatus.OK, "There is an error.");
    }

    @Test
    void checkoutCart() {
        ResponseEntity<String> response = commerceService.checkoutCart(2L);
    }

    @Test
    void findCart() {
        ResponseEntity<CartDto> response = commerceService.findCart();
    }
}