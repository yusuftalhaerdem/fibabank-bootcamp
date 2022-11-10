package com.example.shopping.data.entity;

import com.example.shopping.business.dto.CartProductDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartProductId;
    private Long cartId;
    private Long productId;

    private int salesQuantity;
    private double salesPrice;
    private double lineAmount;

    public CartProduct(Long cartProductId, Long cartId, Long productId, int salesQuantity, double salesPrice, double lineAmount) {
        this.cartProductId = cartProductId;
        this.cartId = cartId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
    }

    public CartProduct() {

    }
    public CartProductDto toDto(){
        return new CartProductDto(this);
    }
/*
    @Override
    public CartProductDto toDto(){
        return new CartProductDto(this);
    }

 */
}
