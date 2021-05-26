package com.bikesrentalapi.repositories;

import com.bikesrentalapi.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
