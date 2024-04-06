package com.kat.recruitapp.mappers;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import com.kat.recruitapp.entities.UserCredentials;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserCredentialsMapper {


    public static UserCredentialsDto mapToDto (UserCredentials userCredentials, UserRepository userRepository){

        Optional<UserEntity> userEntity = userRepository.findById(userCredentials.getUserEntityId());

        UserCredentialsDto userCredentialsDto = UserCredentialsDto.builder()
                .username(userCredentials.getUsername())
                .password(userCredentials.getPassword())
                .phoneNumber(userEntity.get().getPhoneNumber())
                .email(userEntity.get().getEmail())
                .preferredNotificationChannel(String.valueOf(userEntity.get().getPreferredNotificationChannel()))
                .build();

        return userCredentialsDto;
    }

    public static UserCredentials mapToEntity(UserCredentialsDto userCredentialsDto, UserRepository userRepository){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Optional<UserEntity> userEntity = userRepository.getUserEntityByUsername(userCredentialsDto.getUsername());

        UserCredentials userCredentials = UserCredentials.builder()
                .username(userCredentialsDto.getUsername())
                .password(passwordEncoder.encode(userCredentialsDto.getPassword()))
                .userEntityId(userEntity.get().getId())
                .build();

        return userCredentials;
    }

}
