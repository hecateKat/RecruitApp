package com.kat.recruitapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class TransactionDto {

    private UUID id;

    private String sender;

    private String recipient;

    private BigDecimal amount;

    private LocalDateTime time;
}
