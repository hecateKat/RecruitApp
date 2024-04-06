package com.kat.recruitapp.dtos;

import com.kat.recruitapp.entities.UserEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionEvent {

    private TransactionDto transactionDto;

    private UserEntity userEntity;
}
