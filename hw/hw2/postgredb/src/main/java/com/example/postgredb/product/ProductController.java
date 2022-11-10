package com.example.postgredb.product;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventory")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController (ProductRepository productRepository){
        this.productRepository= productRepository;
    }

    @GetMapping("/insert")
    @ResponseBody
    public String insertProduct(){
        Product product = new Product();
        productRepository.save(product);
        return "successfully inserted. id:"+product.getId();
    }



    /*
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

     */

}
