package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.OrderRaw;
import com.bikesrentalapi.models.entities.Bike;
import com.bikesrentalapi.models.entities.Order;
import com.bikesrentalapi.repositories.OrderRepository;
import com.bikesrentalapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @GetMapping
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Order get(@PathVariable("id") Long id) {
        return orderRepository.getById(id);
    }

    @CrossOrigin
    @PostMapping
    public void create(@RequestBody OrderRaw rawOrder){
        this.orderService.createOrder(rawOrder);
    }
}
