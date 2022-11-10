package com.example.postgredb.hw2.service;

import com.example.postgredb.hw2.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CustomerService {

    Customer find(Long customerId);
    List<Customer> findAll();
    Customer createCustomer(Customer customer);

}
