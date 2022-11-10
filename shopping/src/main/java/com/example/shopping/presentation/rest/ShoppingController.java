package com.example.shopping.presentation.rest;

import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.business.services.ShoppingService;
import com.example.shopping.utils.StateHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shopping")
public class ShoppingController {



    private final ShoppingService shoppingService;
    //private final CartService cartService;

    ShoppingController(ShoppingService shoppingService){
        this.shoppingService = shoppingService;
        //this.cartService = cartService;
    }




    // add product into cart
    @PostMapping("cart/add")
    public ResponseEntity<String> updateCart(@RequestBody CartProductDto cartProductDto){
        return shoppingService.updateCartProduct(cartProductDto);
    }
    // removes product from cart
    @DeleteMapping("cart/{cart_id}/remove/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("cart_id") Long cartId, @PathVariable("product_id") Long productId){
        return shoppingService.removeProductFromCart(cartId,productId);
    }

        /*
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>(shoppingService.checkoutCart(cartId));
        return responseBuilder.build();

         */
        //return shoppingService.checkoutCart(cartId);

    // finds cart by customerName
    @GetMapping("cart/find")
    public ResponseEntity<CartDto> findCart(){
        return shoppingService.findCart(StateHolder.getCustomerName());
    }


}
