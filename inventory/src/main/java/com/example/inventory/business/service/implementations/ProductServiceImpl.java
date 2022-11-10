package com.example.inventory.business.service.implementations;

import com.example.inventory.business.dto.ProductDto;
import com.example.inventory.business.service.ProductService;
import com.example.inventory.data.entity.Product;
import com.example.inventory.data.repository.ProductRepository;
import com.example.inventory.util.DtoEntityTransitions;
import com.example.inventory.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<List<ProductDto>> getProductsByCategory(Long categoryId){
        List<Product> products = productRepository.findAllByCategoryId(categoryId);

        List<ProductDto> productDtos = DtoEntityTransitions.productListToDto(products);

        ResponseBuilder<List<ProductDto>> responseBuilder = new ResponseBuilder<>(productDtos);
        return responseBuilder.build();
    }
    public ResponseEntity<ProductDto> getProductById(Long productId){
        Product product = productRepository.findProductByProductId(productId);

        ResponseBuilder<ProductDto> responseBuilder = new ResponseBuilder<>(new ProductDto(product),"No such product exist.");
        return responseBuilder.build();
    }
}
