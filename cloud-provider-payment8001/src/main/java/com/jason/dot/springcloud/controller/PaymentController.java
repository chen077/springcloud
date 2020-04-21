package com.jason.dot.springcloud.controller;

import com.jason.dot.springcloud.entities.CommonResult;
import com.jason.dot.springcloud.entities.Payment;
import com.jason.dot.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        //result 失败 小于0
        log.info("insert values " + payment);
        int result = paymentService.create(payment);
        if(result > 0){
            return new CommonResult(200, "succeed " + serverPort, result);
        }else{
            return new CommonResult(404, "failed", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable Long id){
        //result 失败 小于0
        log.info("finding values" + id);
        Payment result = paymentService.getPaymentById(id);
        if(result != null){
            return new CommonResult(200, "succeed"+ serverPort, result.toString());
        }else{
            return new CommonResult(404, "failed", null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: "+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("333"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
