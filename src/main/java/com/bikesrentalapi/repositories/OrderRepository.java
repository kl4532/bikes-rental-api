package com.bikesrentalapi.repositories;

import com.bikesrentalapi.models.entities.Bike;
import com.bikesrentalapi.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    @Transactional
//    @Modifying
//    @Query("delete from booked_dates bd where bd.bike_id = ?1")
//    void deleteBookedDates(Long id);
}
