package com.example.shopping.business.services.implementations;

import com.example.shopping.business.services.ShoppingService;
import com.example.shopping.data.repository.CartProductRepository;
import com.example.shopping.data.repository.CartRepository;
import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.utils.ResponseBuilder;
import com.example.shopping.data.entity.Cart;
import com.example.shopping.data.entity.CartProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    ShoppingServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository){
        this.cartProductRepository= cartProductRepository;
        this.cartRepository = cartRepository;
    }

/*
    public ResponseEntity<Long> createCart(String customerName){
        Cart cart = new Cart(customerName);
        cartRepository.save(cart);
        ResponseBuilder<Long> responseBuilder = new ResponseBuilder<>(cart.getCartId());
        return responseBuilder.build();
        //return cart.getCartId();
    }

 */

    public ResponseEntity<String> returnErrorMessage(String errorMessage){
        //String errorMessage="cart id does not match with any cart.";
        System.err.println(errorMessage);

        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>(errorMessage);
        return responseBuilder.build();
    }

    public ResponseEntity<String> updateCartProduct(CartProductDto cartProductDto){

        Optional<CartProduct> optionalCartProduct = cartProductRepository.findById(cartProductDto.getCartProductId());

        CartProduct cartProduct;

        Optional<Cart> optionalCart = cartRepository.findById(cartProductDto.getCartId());
        if(optionalCart.isEmpty()){
            return returnErrorMessage("cart id does not match with any cart.");
        }
        Cart cart = optionalCart.get();

        // to be added to cart's total
        double difference= 0;
        if(optionalCartProduct.isPresent()){
            cartProduct = optionalCartProduct.get();

            // checks if cartid and productid matches too.
            if(cartProduct.getCartId()!=cartProductDto.getCartId() || cartProduct.getProductId()!=cartProductDto.getProductId()){
                return returnErrorMessage("cardProductDto's ids does not match with database.");
            }
            difference=cartProductDto.getLineAmount()-cartProduct.getLineAmount();
            cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
            cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
            cartProduct.setLineAmount(cartProductDto.getLineAmount());
        }else{
            cartProduct = cartProductDto.toEntity();
        }
        cart.setTotalAmount(cart.getTotalAmount()+difference);

        System.out.println(cartProductRepository.save(cartProduct));
        System.out.println(cartRepository.save(cart));

        //String successMessage = "cart's content is updated.";

        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("success");
        return responseBuilder.build();
    }

    public ResponseEntity<String> removeProductFromCart(Long cartId, Long productId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if(optionalCart.isEmpty()){
            System.err.println("Given cart id does not match with any cart.");

            ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("Given cart id does not match with any cart.");
            return responseBuilder.build();
            //return "There no such cart";
        }
        Cart cart = optionalCart.get();
        Optional<CartProduct> optionalCartProduct = cartProductRepository.findCartProductByProductId(productId);
        if(optionalCartProduct.isEmpty()){
            System.err.println("Given cartProduct id does not match with any cart.");

            ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("Given cartProduct id does not match with any cart.");
            return responseBuilder.build();
            //return "There no such cartProduct";
        }
        CartProduct cartProduct = optionalCartProduct.get();
        cartProductRepository.delete(cartProduct);

        // updates the sum in the cart
        cart.setTotalAmount(cart.getTotalAmount()-cartProduct.getLineAmount());
        cartRepository.save(cart);

        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("success");
        return responseBuilder.build();
        //return "success";
    }

    /*
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

     */
        /*
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>("success");
        return responseBuilder.build();
         */
        //return "success";
    /*
    }
    */


    public ResponseEntity<CartDto> findCart(String customerName) {
        Optional<Cart> optionalCart = cartRepository.findCartByCustomerName(customerName);
        if(optionalCart.isEmpty()){
            System.err.println("Given cart id does not match with any cart.");
            ResponseBuilder<CartDto> responseBuilder = new ResponseBuilder<>(null,"Given cart id does not match with any cart.");
            return responseBuilder.build();
            //return null;
        }
        CartDto cartDto = new CartDto(optionalCart.get());
        // we add the cart products to cartDto
        List<CartProduct> cartProducts= cartProductRepository.findAllByCartId(cartDto.getCartId());
        List<CartProductDto> cartProductDtos  = cartProducts.stream().map(CartProductDto::new).collect(Collectors.toList());

        cartDto.setCartProducts(cartProductDtos);
        ResponseBuilder<CartDto> responseBuilder = new ResponseBuilder<>(cartDto);
        return responseBuilder.build();
        //return cartDto;

    }

/*
    public List<CartProductDto> entityListToDtoList(List<CartProduct> cartProducts){
        List<CartProductDto> list = new ArrayList<>();
        for(CartProduct cartProduct:cartProducts){
            list.add(new CartProductDto(cartProduct));
        }
        return list;
    }
    public List<? extends Dto> entityListToDtoList(List<? extends MyEntity> entities){
        List<Dto> list = new ArrayList<>();
        for(MyEntity entity:entities){
            list.add(entity.toDto());
        }
        return list;
    }

 */
}
