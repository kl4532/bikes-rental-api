package com.bikesrentalapi.services;

import com.bikesrentalapi.models.Credentials;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
    public AuthService() {}

    public Boolean authenticate(Credentials credentialsFromDb, Credentials credentialsToValidate) {

        if(!credentialsFromDb.getLogin().equals(credentialsToValidate.getLogin()))
            return false;


        if(!credentialsFromDb.getPassword().equals(credentialsToValidate.getPassword()))
            return false;

        return true;
    }
}
