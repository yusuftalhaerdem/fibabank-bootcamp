package com.example.inventory.util;

import org.springframework.http.ResponseEntity;

public class ResponseBuilder<DataType> {
    private DataType responseData;
    private ResponseEntity<DataType> response;
    private String errorMessage= "corresponding object to your request does not exist.";

    public ResponseBuilder(DataType responseData){
        this.responseData = responseData;
    }
    public ResponseBuilder(DataType responseData, String errorMessage){
        this.responseData = responseData;
        this.errorMessage = errorMessage;
    }

    public ResponseEntity<DataType> build(){

        if(responseData==null){
            response = ResponseEntity.ok().header("message",errorMessage).build();
        }else{
            response= ResponseEntity.ok(responseData);
        }
        return response;
    }

    public DataType getResponseData() {
        return responseData;
    }
    public ResponseEntity<DataType> getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
