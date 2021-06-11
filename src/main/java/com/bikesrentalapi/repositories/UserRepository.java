package com.bikesrentalapi.repositories;

import com.bikesrentalapi.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Transactional
//    @Modifying
//    @Query("delete from booked_dates bd where bd.bike_id = ?1")
//    void deleteBookedDates(Long id);
}
