package com.example.inventory.business.dto;

import com.example.inventory.data.entity.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private double salesPrice;
    // may update this
    private Long categoryId;

    public ProductDto(Product product){
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.salesPrice = product.getSalesPrice();
        this.categoryId = product.getCategoryId();
    }
}
