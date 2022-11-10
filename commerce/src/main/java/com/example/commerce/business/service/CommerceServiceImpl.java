package com.example.commerce.business.service;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.util.component.MicroserviceAddresses;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.ProductDto;
import com.example.commerce.util.ResponseBuilder;
import com.example.commerce.util.RestRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceServiceImpl implements CommerceService {


    private final MicroserviceAddresses microserviceAddresses;

    public CommerceServiceImpl(MicroserviceAddresses microserviceAddresses) {
        this.microserviceAddresses= microserviceAddresses;
    }

    // inventory interface

    public ResponseEntity<List<CategoryDto>> getCategories() {
        String url = microserviceAddresses.inventoryCategories();

        RestRequest<List<CategoryDto>, Object> categoryRequest= new RestRequest<>(url,HttpMethod.GET,null);
        categoryRequest.sendRequest();

        System.out.println(categoryRequest.getStatusCode());
        System.out.println(categoryRequest.getResponseBody());
        ResponseBuilder<List<CategoryDto>> responseBuilder = new ResponseBuilder<>(categoryRequest.getResponseBody());
        return responseBuilder.build();
    }

    public ResponseEntity<List<ProductDto>> getProductsByCategory(Long categoryId) {
        String url =microserviceAddresses.inventoryProductsByCategory(categoryId);
        RestRequest<List<ProductDto>,Object> restRequest = new RestRequest<>(url, HttpMethod.GET, null);
        restRequest.sendRequest();
        ResponseBuilder<List<ProductDto>> responseBuilder = new ResponseBuilder<>(restRequest.getResponseBody());
        return responseBuilder.build();
    }

    public ResponseEntity<ProductDto> getProductById(Long productId) {
        String url =microserviceAddresses.inventoryProductById(productId);

        RestRequest<ProductDto,Object> restRequest = new RestRequest<>(url, HttpMethod.GET, null);
        restRequest.sendRequest();

        ObjectMapper mapper = new ObjectMapper();
        ProductDto product =  mapper.convertValue(restRequest.getResponseBody(), ProductDto.class);

        ResponseBuilder<ProductDto> responseBuilder = new ResponseBuilder<>(product);
        return responseBuilder.build();
    }


    // shopping interface

    public ResponseEntity<Long> createCart() {
        String url = microserviceAddresses.shopingCartCreate();

        RestRequest<Long,Object> restRequest = new RestRequest<>(url, HttpMethod.GET, null);
        restRequest.sendRequest();
        ObjectMapper mapper = new ObjectMapper();
        Long response = mapper.convertValue(restRequest.getResponseBody(),Long.class);


        ResponseBuilder<Long> responseBuilder = new ResponseBuilder<>(response);
        return responseBuilder.build();
    }

    public ResponseEntity<String> addProductToCart(CartProductDto cartProductDto) {

        String url =microserviceAddresses.shoppingCartProductUpdate();

        RestRequest<String, CartProductDto> restRequest = new RestRequest<>(url, HttpMethod.POST, cartProductDto);
        restRequest.sendStringRequest();
        System.out.println(restRequest.getResponseBody());

        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>(restRequest.getResponseBody());
        return responseBuilder.build();

    }

    public ResponseEntity<String> removeProductFromCart(Long cartId, Long productId) {

        String url =microserviceAddresses.shoppingCartProductRemove(cartId,productId);

        RestRequest<String, Object> restRequest = new RestRequest<>(url, HttpMethod.DELETE);
        restRequest.sendStringRequest();
        System.out.println(restRequest.getResponseBody());

        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>(restRequest.getResponseBody());
        return responseBuilder.build();

    }

    public ResponseEntity<String> checkoutCart(Long cartId) {
        String url =microserviceAddresses.shoppingCartCheckout(cartId);

        RestRequest<String, Object> restRequest = new RestRequest<>(url, HttpMethod.GET);
        restRequest.sendStringRequest();
        System.out.println(restRequest.getResponseBody());

        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>(restRequest.getResponseBody());
        return responseBuilder.build();

    }


    public ResponseEntity<CartDto> findCart() {

        String url =microserviceAddresses.shoppingCartFind();
        String productRequestUrl = microserviceAddresses.inventoryProductById(null);


        RestRequest<CartDto,Object> restRequest = new RestRequest<>(url, HttpMethod.GET, null);
        restRequest.sendRequest();
        ObjectMapper mapper = new ObjectMapper();
        CartDto cartDto = mapper.convertValue(restRequest.getResponseBody(),CartDto.class);

        // then to complete the cartDto, we fetch product names from inventory.
        for (CartProductDto cartProductDto:cartDto.getCartProducts()){
            RestRequest<ProductDto, Object> productRequest =
                    new RestRequest<>(productRequestUrl+cartProductDto.getProductId(),HttpMethod.GET, null);
            productRequest.sendRequest();
            ProductDto product = mapper.convertValue(productRequest.getResponseBody(),ProductDto.class);
            cartProductDto.setProductName(product.getProductName());
        }

        ResponseBuilder<CartDto> responseBuilder = new ResponseBuilder<>(cartDto);
        return responseBuilder.build();
    }
}
