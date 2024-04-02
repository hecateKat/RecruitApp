package com.kat.recruitapp.mappers;

import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.entities.UserEntity;

public class UserMapper {

    public static UserDto mapToDto (UserEntity userEntity){
        UserDto userDto = UserDto.builder()
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .preferredNotificationChannel(userEntity.getPreferredNotificationChannel())
                .build();

        return userDto;
    }

    public static UserEntity mapToEntity(UserDto userDto){
        UserEntity userEntity = UserEntity.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .preferredNotificationChannel(userDto.getPreferredNotificationChannel())
                .build();

        return userEntity;
    }
}
