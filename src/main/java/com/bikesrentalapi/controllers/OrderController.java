package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.OrderRaw;
import com.bikesrentalapi.repositories.OrderRepository;
import com.bikesrentalapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @PostMapping
    public void create(@RequestBody OrderRaw rawOrder){
        this.orderService.createOrder(rawOrder);
    }
}
