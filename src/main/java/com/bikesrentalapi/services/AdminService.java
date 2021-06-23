package com.bikesrentalapi.services;

import com.bikesrentalapi.models.entities.Admin;
import com.bikesrentalapi.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdminByLogin(String login)
            throws UsernameNotFoundException {
        Admin admin = adminRepository.getAdminByLogin(login);

        if (admin == null) {
            throw new UsernameNotFoundException("Could not find admin with the login: " + login);
        }
        return admin;
    }
}
