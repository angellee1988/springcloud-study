package org.lee.springcloud.controller;

import org.lee.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("order/create")
    public String createOrder() {
        orderService.createOrder(1, 1, 100, 5);
        return  "success";
    }
}
