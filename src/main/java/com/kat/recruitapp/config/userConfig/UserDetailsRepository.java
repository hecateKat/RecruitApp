package com.kat.recruitapp.config.userConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public interface UserDetailsRepository {

    UserDetails loadUserByUsername(String username);
}
