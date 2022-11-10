package com.example.commerce.util.component;

import org.springframework.stereotype.Component;

@Component
public class MicroserviceAddresses {

    public static String INVENTORY= "http://localhost:8081/inventory";
    public static String SHOPPING= "http://localhost:8082/shopping";

    public MicroserviceAddresses(){

    }

    public  String inventoryCategories(){
        return INVENTORY + "/categories";
    }
    public  String inventoryProductsByCategory(Long categoryId){
        return INVENTORY + "/products/"+categoryId;
    }
    public  String inventoryProductById(Long productId){
        return INVENTORY + "/product/"+productId;
    }

    public  String shopingCartCreate(){
        return SHOPPING+"/cart/create";
    }
    public  String shoppingCartProductUpdate(){
        return SHOPPING +"/cart/add";
    }
    public  String shoppingCartProductRemove(Long cartId, Long productId){
        return SHOPPING + "/cart/"+ cartId+"/remove/"+ productId;
    }
    public  String shoppingCartCheckout(Long cartId){
        return SHOPPING +"/checkout/"+cartId;
    }
    public  String shoppingCartFind(){
        return SHOPPING +"/cart/find";
    }


}
