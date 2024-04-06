package com.kat.recruitapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TransactionRequest {

    private String recipient;

    private BigDecimal amount;
}
