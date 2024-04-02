package com.kat.recruitapp.entities;

import com.kat.recruitapp.enums.PreferredNotificationChannel;
import com.kat.recruitapp.validators.email.OwaspEmail;
import com.kat.recruitapp.validators.password.OwaspPassword;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity {

    public static final String SEQ_NAME = "user_id_seq";
    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = UserEntity.SEQ_NAME)
    @SequenceGenerator(name = UserEntity.SEQ_NAME, sequenceName = UserEntity.SEQ_NAME, allocationSize = 1)
    private UUID Id;

    private String username;

    @OwaspPassword
    private String password;

    private String phoneNumber;

    @OwaspEmail
    private String email;

    private PreferredNotificationChannel preferredNotificationChannel;

}
