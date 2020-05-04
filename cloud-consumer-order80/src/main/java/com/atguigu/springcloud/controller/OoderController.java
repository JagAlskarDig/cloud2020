package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OoderController {

    public static final String PAMENT_URL="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return  restTemplate.postForObject(PAMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){

        return  restTemplate.getForObject(PAMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
