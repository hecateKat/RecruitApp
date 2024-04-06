package com.kat.recruitapp.services;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserCredentialsService extends UserDetailsService {

    UserCredentialsDto register(UserCredentialsDto credentials);

    String getAuthenticatedCredentialUsername();

    boolean userCredentialsExistsByUsername(String username);
}
