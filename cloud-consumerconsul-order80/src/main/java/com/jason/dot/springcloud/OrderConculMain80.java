package com.jason.dot.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConculMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderConculMain80.class, args);
    }
}
