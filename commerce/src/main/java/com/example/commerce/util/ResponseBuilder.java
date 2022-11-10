package com.example.commerce.util;

import org.springframework.http.ResponseEntity;

public class ResponseBuilder<T> {
    private T responseData;
    private ResponseEntity<T> response;
    private String errorMessage= "corresponding object to your request does not exist.";

    public ResponseBuilder(T responseData){
        this.responseData = responseData;
    }
    public ResponseBuilder(T responseData, String errorMessage){
        this.responseData = responseData;
        this.errorMessage = errorMessage;
    }

    public ResponseEntity<T> build(){

        if(responseData==null){
            response = ResponseEntity.ok().header("message",errorMessage).build();
        }else{
            response= ResponseEntity.ok(responseData);
        }
        return response;
    }

    public T getResponseData() {
        return responseData;
    }
    public ResponseEntity<T> getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

