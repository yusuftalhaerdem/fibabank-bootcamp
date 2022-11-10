package com.example.postgredb.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    /*
    @Query("select p from Product p where p.price>= :minPrice")
    List<Product> getAllByPriceGreaterThan(@Param("minPrice") double minPrice);

     */
}
