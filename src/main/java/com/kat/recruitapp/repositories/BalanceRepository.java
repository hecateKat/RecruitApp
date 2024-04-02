package com.kat.recruitapp.repositories;

import com.kat.recruitapp.entities.BalanceEntity;
import com.kat.recruitapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, UUID> {

    BalanceEntity findBalanceEntityByUserEntity(UserEntity userEntity);
}
