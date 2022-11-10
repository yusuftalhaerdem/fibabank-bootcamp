package com.example.shopping.business.services.implementations;

import com.example.shopping.business.services.CartService;
import com.example.shopping.utils.ResponseBuilder;
import com.example.shopping.data.entity.Cart;
import com.example.shopping.data.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public ResponseEntity<Long> createCart(String customerName){
        Cart cart = new Cart(customerName);
        cartRepository.save(cart);
        ResponseBuilder<Long> responseBuilder = new ResponseBuilder<>(cart.getCartId());
        return responseBuilder.build();
        //return cart.getCartId();
    }

    public ResponseEntity<String> checkoutCart(Long cartId) {

        //System.out.println("debug");
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        optionalCart.ifPresent(
                cart -> {
                    cart.setCartStatus(false);  // false means checkedout.
                    cartRepository.save(cart);
                }
        );
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("success");
        return responseBuilder.build();
        //return "success";
        /*
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("success");
        return responseBuilder.build();
         */
        //return "success";
    }


}
