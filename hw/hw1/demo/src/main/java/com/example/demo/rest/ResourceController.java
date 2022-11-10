package com.example.demo.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ResourceController {


    @GetMapping("/product")
    public Product getProduct(){
        Product product= new Product(301, "afasfa",1411);
        return product;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") long id){
        Product product= new Product(id, "afasfa",1411);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> productList= new ArrayList<>();
        productList.add(new Product(301, "afasfa",1411));
        productList.add(new Product(302, "afafaasfa",141.41));
        return productList;
    }

    @PostMapping("/product")
    public void postProduct(@RequestBody Product product){
        System.out.println("ürün eklendi. name: "+product.getName());
    }
    @PutMapping("/product")
    public void putProduct(@RequestBody Product product){
        System.out.println("ürün güncellendi. name: "+product.getName());
    }
    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product){
        System.out.println("ürün silindi. name: "+product.getName());
    }

}
