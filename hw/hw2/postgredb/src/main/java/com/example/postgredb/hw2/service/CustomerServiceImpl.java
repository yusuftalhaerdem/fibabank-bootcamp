package com.example.postgredb.hw2.service;

import com.example.postgredb.hw2.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements  CustomerService{

    public Customer find(Long customerId) {
        Customer customer = new Customer(customerId, "Erdal Bakkal", 15000);

        System.out.println("Müşteri kaydı bulundu: " + customer.getCustomerId() +
                " " + customer.getCustomerName() + " " + customer.getTotalDebit());

        return customer;
    }

    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(3L, "Temel dursun", 4000));
        customerList.add(new Customer(4L, "Yahya kemal", 96.4));

        return customerList;
    }

    public Customer createCustomer(Customer customer) {

        customer.setCustomerId(14L);
        System.out.println(customer);
        System.out.println("success");
        return customer;
    }
}
