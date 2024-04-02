package com.kat.recruitapp.mappers;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.entities.BalanceEntity;

public class BalanceMapper {

    public static BalanceDto mapToDto (BalanceEntity balanceEntity){
        BalanceDto balanceDto = BalanceDto.builder()
                .id(balanceEntity.getId())
                .amount(balanceEntity.getAmount())
                .balanceId(balanceEntity.getBalanceId())
                .userDto(UserMapper.mapToDto(balanceEntity.getUserEntity()))
                .build();

        return balanceDto;
    }

    public static BalanceEntity mapToEntity(BalanceDto balanceDto){
        BalanceEntity balanceEntity = BalanceEntity.builder()
                .id(balanceDto.getId())
                .amount(balanceDto.getAmount())
                .balanceId(balanceDto.getBalanceId())
                .userEntity(UserMapper.mapToEntity(balanceDto.getUserDto()))
                .build();

        return balanceEntity;
    }
}
