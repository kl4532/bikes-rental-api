package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.Bike;
import com.bikesrentalapi.models.BookedDates;
import com.bikesrentalapi.repositories.BikeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
    @Autowired
    private BikeRepository bikeRepository;

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
    public Bike create(@RequestParam(value = "picture", required = false) MultipartFile picture, @RequestPart("bike") Bike bike) throws IOException {
        if (picture != null) {
            bike.setPicture(picture);
        }

        List<BookedDates> bookedDates = bike.getBookedDates();
        for (BookedDates bd : bookedDates) {
            bd.setBike(bike);
        }
        System.out.println("Bike created with a name: " + bike.getName());
        return bikeRepository.saveAndFlush(bike);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        try {
            bikeRepository.deleteBookedDates(id);
            bikeRepository.deleteById(id);
            System.out.println("Removed bike with id: " + id);
        } catch (Exception e) {
            System.out.println("An error when removing bike with id: " + id);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Bike update(@PathVariable Long id, @RequestBody Bike bike) throws Exception {
        Bike bikeExisting = bikeRepository.findById(id)
                .orElseThrow(() -> new Exception("Bike with id: " + id + "not found"));
        List<BookedDates> bookedDates = bike.getBookedDates();
        for (BookedDates bd : bookedDates) {
            bd.setBike(bike);
        }

        BeanUtils.copyProperties(bike, bikeExisting, "id");
        bikeRepository.deleteBookedDates(id);

        bike.setBookedDates(bookedDates);
        bike.setId(bikeExisting.getId());

        System.out.println("+++UPDATE+++");
        System.out.printf("Bike with id: %s successfully updated", bike.getId());
        return bikeRepository.save(bike);
    }
}
