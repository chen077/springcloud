package com.jason.dot.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return  "springcloud with consul: "+port+"\t   "+ UUID.randomUUID().toString();
    }
}
