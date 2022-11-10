package com.example.shopping.business.services.implementations;

import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.business.services.ShoppingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ShoppingServiceImplTest {
    @Autowired
    ShoppingService shoppingService;

    @Test
    void updateCartProduct() throws Exception{
        CartProductDto cartProductDto = new CartProductDto(6L,2L,4L,2,240.0,480.0,null);

        ResponseEntity<String> response = shoppingService.updateCartProduct(cartProductDto);


        System.out.println(response.getBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while updating cart product.");
        /*
         */
    }

    @Test
    void removeProductFromCart() throws Exception{
        CartProductDto cartProductDto = new CartProductDto(6L,2L,4L,2,240.0,480.0,null);
        ResponseEntity<String> response = shoppingService.updateCartProduct(cartProductDto);
        System.out.println(response.getBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Due to error in updateCartProduct, removeProductFromCart function could be tested.");

        ResponseEntity<String> response2 = shoppingService.removeProductFromCart(2L,4L);
        System.out.println(response2.getBody());
        assertEquals(response2.getStatusCode(), HttpStatus.OK,"Error occurred while updating cart product.");
    }

    @Test
    void findCart() throws Exception{
        ResponseEntity<CartDto> response = shoppingService.findCart("yusuf");
        System.out.println(response.getBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK,"Error occurred while updating cart product.");
    }
}