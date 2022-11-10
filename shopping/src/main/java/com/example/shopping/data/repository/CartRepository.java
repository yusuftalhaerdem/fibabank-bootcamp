package com.example.shopping.data.repository;

import com.example.shopping.data.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    public Optional<Cart> findCartByCustomerName(String customerName);
}
