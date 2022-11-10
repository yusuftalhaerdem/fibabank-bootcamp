package com.example.demo.rest;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    private long id;
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
