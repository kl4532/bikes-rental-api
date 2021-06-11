package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.entities.Bike;
import com.bikesrentalapi.repositories.BikeRepository;
import com.bikesrentalapi.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {
    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BikeService bikeService;

    @CrossOrigin
    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") Long id) {
        return bikeRepository.getById(id);
    }

    @CrossOrigin
    @PostMapping(consumes = {"multipart/form-data"})
    public void create(@RequestParam(value = "picture", required = false) MultipartFile picture, @RequestPart("bike") Bike bike) throws IOException {
        this.bikeService.createBike(picture, bike);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.bikeService.deleteBike(id);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public void update(@PathVariable Long id, @RequestPart Bike bike, @RequestParam(value = "picture", required = false) MultipartFile picture) throws Exception {
        this.bikeService.updateBike(id, bike, picture);
    }
}
