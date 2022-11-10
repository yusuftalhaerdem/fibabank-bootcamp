package com.example.postgredb.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    public Product(long i, String s, double price) {
        this.id= i;
        this.name= s;
        this.price= price;
    }

    public Product() {

    }
}
