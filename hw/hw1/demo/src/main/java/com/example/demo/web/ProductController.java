package com.example.demo.web;

import com.example.demo.rest.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class ProductController {

    @GetMapping("product/get")
    @ResponseBody
    public String getProduct(){
        int productId = 11;
        String url = "http://localhost:8080/api/product/"+ productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);
        return "successful getting. product: "+product;
    }

    @GetMapping("product/post")
    @ResponseBody
    public String postProduct(){
        Product product = new Product(1141,"adfaf",1151.41);

        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, product, Product.class);

        return "successful posting. product: "+product;
    }
    @GetMapping("product/put")
    @ResponseBody
    public String putProduct(){
        Product product = new Product(1141,"adfaf",1151.41);

        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(product), Void.class);

        return "successful putting. product: "+product;
    }
    @GetMapping("product/put")
    @ResponseBody
    public String deleteProduct(){
        Product product = new Product(1141,"adfaf",1151.41);

        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(product), Void.class);

        return "successful deleting. product: "+product;
    }
}
