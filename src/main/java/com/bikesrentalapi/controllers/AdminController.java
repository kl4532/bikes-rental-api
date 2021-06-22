package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.entities.Admin;
import com.bikesrentalapi.repositories.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @CrossOrigin
    @GetMapping("/{login}")
    public Admin get(@PathVariable("login") String login) {
        return adminRepository.getAdminByLogin(login);
    }

}
