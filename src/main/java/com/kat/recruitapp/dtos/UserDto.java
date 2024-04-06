package com.kat.recruitapp.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private String username;

    private String phoneNumber;

    private String email;

    private String preferredNotificationChannel;
}
