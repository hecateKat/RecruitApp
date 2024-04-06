package com.kat.recruitapp.repositories;

import com.kat.recruitapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> getUserEntityByUsername(String username);

    boolean existsUserEntityByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
}
