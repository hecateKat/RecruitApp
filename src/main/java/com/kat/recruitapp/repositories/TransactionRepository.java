package com.kat.recruitapp.repositories;

import com.kat.recruitapp.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

    int countTransactionEntitiesBySenderAndTransactionTimeBetween(String sender, LocalDateTime time, LocalDateTime lastTransaction);
}
