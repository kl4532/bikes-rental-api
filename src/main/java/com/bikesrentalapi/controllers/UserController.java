package com.bikesrentalapi.controllers;

import com.bikesrentalapi.models.entities.User;
import com.bikesrentalapi.repositories.UserRepository;
import com.bikesrentalapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }
}
