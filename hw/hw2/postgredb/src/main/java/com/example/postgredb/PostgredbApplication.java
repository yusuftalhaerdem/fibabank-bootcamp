package com.example.postgredb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class })
public class PostgredbApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgredbApplication.class, args);
    }

}
