package com.example.commerce.util;

/**/
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestRequest<ResponseType, RequestDataType> {

    private String url;
    private HttpMethod httpMethod;
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private RequestDataType requestData;
    private ResponseEntity<ResponseType> response;
    //private boolean noProblem;
    private HttpStatus statusCode;
    private ResponseType responseBody;

    private String errorMessage;

    public RestRequest(String url, HttpMethod httpMethod, RequestDataType requestData){
        this.url = url;
        this.httpMethod= httpMethod;
        this.requestData= requestData;

        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
    }
    public RestRequest(String url, HttpMethod httpMethod){
        this.url = url;
        this.httpMethod= httpMethod;
        requestData= null;

        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
    }
    public void addHeader(String headerName,String headerContent){
        headers.add(headerName,headerContent);
    }

    public void sendRequest(){
        HttpEntity<RequestDataType> requestEntity = new HttpEntity<>(requestData,headers);
        response = restTemplate.exchange(url, httpMethod,
                requestEntity, new ParameterizedTypeReference<>(){});
        //this.response=response;
        updateFields();
    }
    public void sendStringRequest(){
        HttpEntity<?> requestEntity = new HttpEntity<>(requestData,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, httpMethod,
                requestEntity, String.class);
        this.response= (ResponseEntity<ResponseType>) response;
        //this.response=response;
        updateFields();
    }

    private void updateFields(){

        statusCode = response.getStatusCode();
        //noProblem= response.getStatusCode() == HttpStatus.OK;
        responseBody = response.getBody();
        if(responseBody == null) {
            try {
                errorMessage = response.getHeaders().get("message").get(0);
            }catch (Exception e){
                System.err.println("Request return value is null but no errorMessage is included. Look for the problem.");
            }
        }
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public ResponseEntity<ResponseType> getResponse() {
        return response;
    }
    public HttpStatus getStatusCode() {
        return statusCode;
    }
    public ResponseType getResponseBody() {
        return responseBody;
    }
    public String getErrorMessage(){
        return errorMessage;
    }

    /*
    public boolean isNoProblem() {
        return noProblem;
    }
     */
}
