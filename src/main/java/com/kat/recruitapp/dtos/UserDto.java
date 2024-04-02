package com.kat.recruitapp.dtos;

import com.kat.recruitapp.enums.PreferredNotificationChannel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private PreferredNotificationChannel preferredNotificationChannel;
}
