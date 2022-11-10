package com.example.commerce.business.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CartProductDto{

    private Long cartProductId;
    private Long cartId;
    private Long productId;

    private int salesQuantity;
    private double salesPrice;
    private double lineAmount;

    // parameters not derived from CartProduct
    private String productName;





    public CartProductDto(Long cartProductId, Long cartId, Long productId, int salesQuantity, double salesPrice, double lineAmount) {
        this.cartProductId = cartProductId;
        this.cartId = cartId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
    }

    public CartProductDto(Long cartProductId, Long cartId, Long productId, int salesQuantity, double salesPrice, double lineAmount, String productName) {
        this.cartProductId = cartProductId;
        this.cartId = cartId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
        this.productName = productName;
    }

    public CartProductDto(){

    }
    /**/

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
