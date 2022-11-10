package com.example.shopping.business.services.implementations;

import com.example.shopping.business.services.CartService;
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
class CartServiceImplTest {

    @Autowired
    CartService cartService;

    @Test
    void createCart() {
        ResponseEntity<Long> response = cartService.createCart(null);
        System.out.println(response.getBody());
        assertEquals(response.getStatusCode(),HttpStatus.OK, "Error occurred while creating new cart.");
    }

    @Test
    void checkoutCart() {
        ResponseEntity<String> response = cartService.checkoutCart(2L);
        System.out.println(response.getBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while creating new cart.");
    }
}