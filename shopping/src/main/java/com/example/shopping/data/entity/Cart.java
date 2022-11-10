package com.example.shopping.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String customerName;
    private double totalAmount;
    // active-> true, non-active/paid->false
    private boolean cartStatus=true;

    public Cart(String customerName){
        this.customerName= customerName;
    }
    public Cart(){}

    /*
    @Override
    public CartDto toDto(){
        return new CartDto(this);
    }
*/
}
