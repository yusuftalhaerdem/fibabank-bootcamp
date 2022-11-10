package com.example.postgredb.hw2.rest;

import com.example.postgredb.hw2.entity.Customer;
import com.example.postgredb.hw2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/find")
    public Customer findCustomer(@PathVariable("customer_id") Long customerId){
        return customerService.find(customerId);
    }
    @GetMapping("/customer/findall")
    public List<Customer> findCustomer(){
        return customerService.findAll();
    }
    @GetMapping("custoemr/create")
    public Customer createCustomer(){
        return customerService.createCustomer(new Customer(4L, "joseph morinyo",14.4));
    }

}
