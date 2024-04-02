package com.kat.recruitapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
public class BalanceDto {

    private UUID id;

    private BigDecimal amount;

    private String balanceId;

    private UserDto userDto;
}
