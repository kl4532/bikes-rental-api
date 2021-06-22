package com.bikesrentalapi.repositories.admin;

import com.bikesrentalapi.models.entities.Admin;

public interface CustomAdminRepository {
    Admin getAdminByLogin(String login);
}
