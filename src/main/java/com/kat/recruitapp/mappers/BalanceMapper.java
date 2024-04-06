package com.kat.recruitapp.mappers;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.entities.BalanceEntity;

public class BalanceMapper {

    public static BalanceDto mapToDto (BalanceEntity balanceEntity){
        BalanceDto balanceDto = BalanceDto.builder()
                .id(balanceEntity.getId())
                .amount(balanceEntity.getAmount())
                .balanceId(balanceEntity.getBalanceId())
                .build();

        return balanceDto;
    }
}