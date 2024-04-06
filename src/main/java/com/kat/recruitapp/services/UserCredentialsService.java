package com.kat.recruitapp.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserCredentialsService extends UserDetailsService {

    String getAuthenticatedCredentialUsername();

    boolean userCredentialsExistsByUsername(String username);
}
