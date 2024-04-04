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
@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
        return Objects.equals(id, that.id) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
