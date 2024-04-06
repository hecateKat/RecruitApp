package com.kat.recruitapp.mappers;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.enums.PreferredNotificationChannel;

public class UserMapper {

    public static UserDto mapToDto (UserEntity userEntity){
        UserDto userDto = UserDto.builder()
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .preferredNotificationChannel(String.valueOf(userEntity.getPreferredNotificationChannel()))
                .build();

        return userDto;
    }


    public static UserEntity mapFromUserCredentialDto(UserCredentialsDto userCredentialsDto){
        UserEntity userEntity = UserEntity.builder()
                .username(userCredentialsDto.getUsername())
                .email(userCredentialsDto.getEmail())
                .phoneNumber(userCredentialsDto.getPhoneNumber())
                .preferredNotificationChannel(PreferredNotificationChannel.valueOf(userCredentialsDto.getPreferredNotificationChannel()))
                .build();

        return userEntity;
    }
}
