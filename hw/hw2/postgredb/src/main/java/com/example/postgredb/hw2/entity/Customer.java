package com.example.postgredb.hw2.entity;

import lombok.Data;

@Data
public class Customer {
    private Long customerId;
    private String customerName;
    private double totalDebit;


    public Customer(long l, String name, double v) {
        customerId=l;
        customerName=name;
        totalDebit=v;
    }
}
