package com.kat.recruitapp.services;

import com.kat.recruitapp.dtos.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<UserDto> getUserById(UUID Id);

    UserDto save(UserDto user);

    void deleteUser(UUID id);
//
//    boolean checkUserExistByUsername(String username);
}
