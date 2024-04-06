package com.kat.recruitapp.dtos;

import com.kat.recruitapp.validators.email.OwaspEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserCredentialsDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String phoneNumber;

    @OwaspEmail
    private String email;

    @NotNull
    private String preferredNotificationChannel;
}
