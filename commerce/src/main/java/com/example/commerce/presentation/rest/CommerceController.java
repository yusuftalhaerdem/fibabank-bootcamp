package com.example.commerce.presentation.rest;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.dto.ProductDto;
import com.example.commerce.business.service.CommerceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commerce")
public class CommerceController {


    // todo: we may read customerName from header.
    private final String customerName= "yusuf";

    private CommerceServiceImpl commerceService;

    CommerceController(CommerceServiceImpl commerceService){
        this.commerceService= commerceService;
    }

    @GetMapping("inventory/categories")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return commerceService.getCategories();
        //return commerceService.getCategories(); // ArrayList<Category>
    }
    @GetMapping("inventory/products/{category_id}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable("category_id") Long categoryId){
        return commerceService.getProductsByCategory(categoryId);
    }
    @GetMapping("inventory/product/{product_id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("product_id") Long productId){

        return commerceService.getProductById(productId);
    }
    @GetMapping("shopping/cart/create")
    public ResponseEntity<Long> createCart(){

        return commerceService.createCart();
    }
    @PostMapping("shopping/cart/add")
    public ResponseEntity<String> addToCart(@RequestBody CartProductDto cartProductDto){

        return commerceService.addProductToCart(cartProductDto);
    }
    @DeleteMapping("shopping/cart/{cart_id}/remove/{product_id}")
    public ResponseEntity<String> removeCartItem(@PathVariable("cart_id") Long cartId, @PathVariable("product_id") Long productId){

        return commerceService.removeProductFromCart(cartId, productId);
    }
    @GetMapping("shopping/checkout/{cart_id}")
    public ResponseEntity<String> getCheckout(@PathVariable("cart_id") Long cartId){

        return commerceService.checkoutCart(cartId);
    }
    @GetMapping("shopping/cart/find")
    public ResponseEntity<CartDto> getCart(){

        return commerceService.findCart();
    }
}
