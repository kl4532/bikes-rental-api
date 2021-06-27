package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.OrderRaw;
import com.bikesrentalapi.models.entities.BikeDetails;
import com.bikesrentalapi.models.entities.Order;
import com.bikesrentalapi.repositories.BikeDetailsRepository;
import com.bikesrentalapi.repositories.OrderRepository;
import com.bikesrentalapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/bike_details")
public class BikeDetailsController {
    @Autowired
    private BikeDetailsRepository bdRepository;

    @CrossOrigin
    @GetMapping
    public List<BikeDetails> getAllDetails() {
        return bdRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{name}")
    public List<String> getDetailsByName(@PathVariable("name") String name) {
        return bdRepository.getDetailsByName(name);
    }
}
