package com.kat.recruitapp.mappers;

import com.kat.recruitapp.dtos.TransactionDto;
import com.kat.recruitapp.entities.TransactionEntity;

public class TransactionMapper {

    public static TransactionDto mapToDto (TransactionEntity transactionEntity){
        TransactionDto transactionDto = TransactionDto.builder()
                .id(transactionEntity.getId())
                .sender(transactionEntity.getSender())
                .recipient(transactionEntity.getRecipient())
                .amount(transactionEntity.getAmount())
                .time(transactionEntity.getTransactionTime())
                .build();

        return transactionDto;
    }
}