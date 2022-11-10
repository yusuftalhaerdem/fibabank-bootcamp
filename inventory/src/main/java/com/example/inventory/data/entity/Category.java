package com.example.inventory.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    public Category(String categoryName){
        this.categoryName=categoryName;
    }

    public Category() {

    }
}
