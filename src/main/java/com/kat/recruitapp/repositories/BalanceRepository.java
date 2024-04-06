package com.kat.recruitapp.repositories;

import com.kat.recruitapp.entities.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, UUID> {

    @Query(value = "SELECT b FROM BalanceEntity b INNER JOIN UserEntity u ON u.id = b.userEntity.id WHERE u.username = :userUsername")
    Optional<BalanceEntity> getUserBalanceByUsername(@Param("userUsername")String username);

    Optional<BalanceEntity> getUserBalanceByBalanceId(String balanceId);
}
