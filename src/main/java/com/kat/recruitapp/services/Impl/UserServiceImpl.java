package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.mappers.UserMapper;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDto> getUserById(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        UserEntity userEntity = user.get();
        return Optional.of(UserMapper.mapToDto(userEntity));
    }

    @Override
    public UserDto save(UserDto user) {
        UserEntity userEntity = userRepository.save(UserMapper.mapToEntity(user));
        return UserMapper.mapToDto(userEntity);
    }

    @Override
    public UserDto loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userDetailsRepository.loadUserByUsername(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        // Create and return the Spring Security UserDetails object
        return org.springframework.security.core.userdetails.User.builder()
                .username(userDetails.getUsername())
                .password(userDetails.getPassword())

                .build();
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
