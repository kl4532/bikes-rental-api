package com.bikesrentalapi.services;

import com.bikesrentalapi.models.entities.Bike;
import com.bikesrentalapi.models.entities.BookedDates;
import com.bikesrentalapi.repositories.BikeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public Bike createBike(MultipartFile picture, Bike bike) throws IOException {
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

    public void deleteBike(Long id) {
        try {
            bikeRepository.deleteBookedDates(id);
            bikeRepository.deleteById(id);
            System.out.println("Removed bike with id: " + id);
        } catch (Exception e) {
            System.out.println("An error when removing bike with id: " + id);
        }
    }

    public Bike updateBike(Long id, Bike bike, MultipartFile picture) throws Exception {
        Bike bikeExisting = bikeRepository.findById(id)
                .orElseThrow(() -> new Exception("Bike with id: " + id + "not found"));

        if (picture != null) {
            bike.setPicture(picture);
        }

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
