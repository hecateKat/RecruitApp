package com.kat.recruitapp.services;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import com.kat.recruitapp.dtos.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<UserDto> getUserById(UUID Id);

    UserDto saveUser(UserCredentialsDto user);

    UserDto getUserDetailsByUsername(String username);

    void deleteUser(UUID id);
}
