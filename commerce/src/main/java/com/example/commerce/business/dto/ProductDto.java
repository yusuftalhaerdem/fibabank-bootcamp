package com.example.commerce.business.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private double salesPrice;
    // may update this
    private Long categoryId;

}
