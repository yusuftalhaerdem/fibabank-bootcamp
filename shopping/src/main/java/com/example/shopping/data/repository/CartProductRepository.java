package com.example.shopping.data.repository;

import com.example.shopping.data.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    public Optional<CartProduct> findCartProductByProductId(Long productId);

    public List<CartProduct> findAllByCartId(Long cartId);

    public List<CartProduct> findAllByCartIdAndAndProductId(Long cartId, Long productId);

}
