package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.Credentials;
import com.bikesrentalapi.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @CrossOrigin
    @PostMapping(value = "/login", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean login(@RequestBody Credentials credentials) {
        return adminService.isAdmin(credentials);
    }

}
