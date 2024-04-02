package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.mappers.UserMapper;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

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
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
