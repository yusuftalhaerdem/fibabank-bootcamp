package com.example.shopping.business.dto;

import com.example.shopping.data.entity.CartProduct;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDto{

    private Long cartProductId;
    private Long cartId;
    private Long productId;

    private int salesQuantity;
    private double salesPrice;
    private double lineAmount;

    // parameters not derived from CartProduct
    private String productName;


    public CartProduct toEntity(){
        return new CartProduct(cartProductId, cartId, productId, salesQuantity, salesPrice, lineAmount);
    }


    public CartProductDto(CartProduct cartProduct){
        this.cartProductId = cartProduct.getCartProductId();
        this.cartId = cartProduct.getCartId();
        this.productId = cartProduct.getProductId();
        this.salesQuantity = cartProduct.getSalesQuantity();
        this.salesPrice = cartProduct.getSalesPrice();
        this.lineAmount = cartProduct.getLineAmount();
    }

    /*
    public CartProductDto(Long cartProductId, Long cartId, Long productId, int salesQuantity, double salesPrice, double lineAmount) {
        this.cartProductId = cartProductId;
        this.cartId = cartId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
    }

    public CartProductDto(){

    }
    */

    @Override
    public String toString() {
        return "CartProductDto{" +
                "cartProductId=" + cartProductId +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", salesQuantity=" + salesQuantity +
                ", salesPrice=" + salesPrice +
                ", lineAmount=" + lineAmount +
                ", productName='" + productName + '\'' +
                '}';
    }

}
