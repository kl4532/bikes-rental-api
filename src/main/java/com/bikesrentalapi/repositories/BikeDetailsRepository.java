package com.bikesrentalapi.repositories;

import com.bikesrentalapi.models.entities.BikeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BikeDetailsRepository extends JpaRepository<BikeDetails, Long> {
    @Query(value = "SELECT * FROM bike_details WHERE name = :name", nativeQuery = true)
    List<String> getDetailsByName(@Param("name") String name);
}
