package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.Bike;
import com.bikesrentalapi.models.BookedDates;
import com.bikesrentalapi.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") Long id) {
        return bikeRepository.getById(id);
    }

    @PostMapping
    public Bike create(@RequestBody final Bike bike) {
        List<BookedDates> bookedDates = bike.getBookedDates();
        for (BookedDates bd : bookedDates) {
            bd.setBike(bike);
        }
        return bikeRepository.saveAndFlush(bike);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        bikeRepository.deleteById(id);
    }
}
