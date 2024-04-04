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
                .build();

        return transactionDto;
    }

    public static TransactionEntity mapToEntity(TransactionDto transactionDto){
        TransactionEntity transactionEntity = TransactionEntity.builder()
                .id(transactionDto.getId())
                .sender(transactionDto.getSender())
                .recipient(transactionDto.getRecipient())
                .amount(transactionDto.getAmount())
                .build();

        return transactionEntity;
    }
}
