package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import com.kat.recruitapp.entities.UserCredentials;
import com.kat.recruitapp.exceptions.AuthenticationFailException;
import com.kat.recruitapp.mappers.UserCredentialsMapper;
import com.kat.recruitapp.repositories.UserCredentialsRepository;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.UserCredentialsService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private final UserCredentialsRepository userCredentialsRepository;

    private final UserRepository userRepository;

    public UserCredentialsServiceImpl(UserCredentialsRepository userCredentialsRepository, UserRepository userRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String getAuthenticatedCredentialUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return auth.getName();
        }
        throw new AuthenticationFailException("Authorization failed");
    }

    @Override
    public boolean userCredentialsExistsByUsername(String username) {
        return userCredentialsRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialsDto dto = getUserCredentialUsername(username);
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }

    private UserCredentialsDto getUserCredentialUsername(String username) {
        UserCredentials credentials = userCredentialsRepository.findUserCredentialsByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
        return UserCredentialsMapper.mapToDto(credentials, userRepository);
    }
}