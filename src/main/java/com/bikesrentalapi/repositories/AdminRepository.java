package com.bikesrentalapi.repositories;

import com.bikesrentalapi.models.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "SELECT * FROM admins WHERE login = :login", nativeQuery = true)
    Admin getAdminByLogin(@Param("login") String login);
}
