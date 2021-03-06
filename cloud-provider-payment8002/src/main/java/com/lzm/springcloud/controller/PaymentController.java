package com.lzm.springcloud.controller;

import com.lzm.springcloud.entities.CommonResult;
import com.lzm.springcloud.entities.Payment;
import com.lzm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200,"插入数据库中成功,serverPort: " + serverPort, payment);
        }else {
            return new CommonResult(444,"传插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功, serverPort: " + serverPort, payment);
        }else {
            return new CommonResult(444,"没有对应的记录，查询的id：" + id,null);
        }
    }
}
