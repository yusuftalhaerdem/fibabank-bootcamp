package com.example.commerce.business.dto;

import java.util.List;

public class CartDto {

    private Long cartId;
    private String customerName;

    // active-> true, non-active/paid->false
    private boolean cartStatus;

    private List<CartProductDto> cartProducts;



    public CartDto() {

    }

    public CartDto(Long cartId, String customerName, boolean cartStatus, List<CartProductDto> cartProducts) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cartStatus = cartStatus;
        this.cartProducts = cartProducts;
    }

    public void addCartProducts(List<CartProductDto> cartProducts){
        this.cartProducts.addAll(cartProducts);
    }
    public void addCartProduct(CartProductDto cartProduct){
        this.cartProducts.add(cartProduct);
    }

    public Long getCartId() {
        return cartId;
    }
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public boolean isCartStatus() {
        return cartStatus;
    }
    public void setCartStatus(boolean cartStatus) {
        this.cartStatus = cartStatus;
    }
    public List<CartProductDto> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProductDto> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", cartStatus=" + cartStatus +
                ", cartProducts=" + cartProducts +
                '}';
    }
}
