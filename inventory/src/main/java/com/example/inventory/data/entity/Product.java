package com.example.inventory.data.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private double salesPrice;
    // may update this
    private Long categoryId;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", salesPrice=" + salesPrice +
                ", categoryId=" + categoryId +
                '}';
    }
}
