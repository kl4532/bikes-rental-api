package com.bikesrentalapi.services;

import com.bikesrentalapi.models.Credentials;
import com.bikesrentalapi.models.entities.Admin;
import com.bikesrentalapi.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AuthService authService;

    public Boolean isAdmin(Credentials credentialsToValidate) {
        Admin admin = adminRepository.getAdminByLogin(credentialsToValidate.getLogin());
        if (admin == null) {
            System.out.println("Could not find admin with the login: " + credentialsToValidate.getLogin());
            return false;
        }

        String login = admin.getLogin();
        String password = admin.getPassword();
        Credentials credentialsFromDb = new Credentials(login, password);

        return authService.authenticate(credentialsFromDb, credentialsToValidate);
    }
}
