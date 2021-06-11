package com.bikesrentalapi.services;

import com.bikesrentalapi.models.entities.User;
import com.bikesrentalapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}
