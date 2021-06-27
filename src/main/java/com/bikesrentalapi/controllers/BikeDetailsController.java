package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.entities.BikeDetails;
import com.bikesrentalapi.models.entities.BikeFormFields;
import com.bikesrentalapi.repositories.BikeDetailsRepository;
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
    public BikeFormFields getAllDetails() {
        List<BikeDetails> bikeDetails = bdRepository.findAll();

        BikeFormFields bff =  new BikeFormFields();
        bff.setType(bikeDetails.get(0).getValues());
        bff.setSize(bikeDetails.get(1).getValues());
        bff.setStatus(bikeDetails.get(2).getValues());
        return bff;
    }

    @CrossOrigin
    @GetMapping("/{name}")
    public List<String> getDetailsByName(@PathVariable("name") String name) {
        return bdRepository.getDetailsByName(name);
    }
}
