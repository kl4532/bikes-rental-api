package com.bikesrentalapi.repositories;

import com.bikesrentalapi.models.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Transactional
    @Modifying
    @Query("delete from booked_dates bd where bd.bikeId = ?1")
    void deleteBookedDates(Long id);
}
