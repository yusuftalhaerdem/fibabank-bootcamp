package com.example.shopping.presentation.rest;

import com.example.shopping.business.services.CartService;
import com.example.shopping.utils.StateHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shopping")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // creates cart
    @GetMapping("cart/create")
    public ResponseEntity<Long> getCreateCartRequest(){
        return cartService.createCart(StateHolder.getCustomerName());
    }
    // pays the cart's content
    @GetMapping("checkout/{cart_id}")
    public ResponseEntity<String> checkout(@PathVariable("cart_id") Long cartId) {
        return cartService.checkoutCart(cartId);
    }
}
