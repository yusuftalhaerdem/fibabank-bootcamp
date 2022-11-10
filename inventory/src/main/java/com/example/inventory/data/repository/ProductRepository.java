package com.example.inventory.data.repository;

import com.example.inventory.data.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findAllByCategoryId(Long categoryId);
    public Product findProductByProductId(Long productId);
}
