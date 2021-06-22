package com.bikesrentalapi.repositories.admin;

import com.bikesrentalapi.models.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long>, CustomAdminRepository {
}
