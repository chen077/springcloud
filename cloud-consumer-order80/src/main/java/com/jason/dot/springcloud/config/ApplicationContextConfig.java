package com.jason.dot.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    //ribbon 和 eureka 整合后consumer 可以直接调用服务不用关心地址和端口号，
    //且具有负载均衡功能
    @Bean
    @LoadBalanced // ribbon 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//applicationContext, bean