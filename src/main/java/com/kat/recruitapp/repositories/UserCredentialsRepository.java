package com.kat.recruitapp.repositories;

import com.kat.recruitapp.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, UUID> {

    Optional<UserCredentials> findUserCredentialsByUsername(String username);

    boolean existsByUsername(String username);
}
