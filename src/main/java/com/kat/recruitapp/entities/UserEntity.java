package com.kat.recruitapp.entities;

import com.kat.recruitapp.enums.PreferredNotificationChannel;
import com.kat.recruitapp.validators.email.OwaspEmail;
import com.kat.recruitapp.validators.password.OwaspPassword;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity {

    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    private String username;

    @OwaspPassword
    private String password;

    private String phoneNumber;

    @OwaspEmail
    private String email;

    @Enumerated(EnumType.STRING)
    private PreferredNotificationChannel preferredNotificationChannel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(Id, that.Id) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, username);
    }
}
