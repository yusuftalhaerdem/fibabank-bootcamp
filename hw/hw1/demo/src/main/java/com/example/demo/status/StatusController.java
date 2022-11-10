package com.example.demo.status;

import com.example.demo.rest.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {

    @GetMapping("/ok")
    public ResponseEntity<?> getOk(){
        Product product= new Product(301, "afasfa",1411);
        return ResponseEntity
                .ok()
                .body(product);
    }

    @GetMapping("/notFound")
    public ResponseEntity<?> getNotFound(){
        Product product= new Product(301, "afasfa",1411);
        return ResponseEntity
                .notFound()
                .build();
                /*
                .status(HttpStatus.MULTI_STATUS)
                .body(product);
                 */
    }
}
