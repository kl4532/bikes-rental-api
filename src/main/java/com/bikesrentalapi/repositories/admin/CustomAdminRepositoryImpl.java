package com.bikesrentalapi.repositories.admin;

import com.bikesrentalapi.models.entities.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAdminRepositoryImpl implements CustomAdminRepository{
    @Override
    public Admin getAdminByLogin(String login) {
        return new Admin();
    }
}
