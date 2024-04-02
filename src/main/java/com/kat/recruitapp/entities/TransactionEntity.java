package com.kat.recruitapp.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionEntity {

    private UUID id;

    private String sender;

    private String recipient;

    private BigDecimal amount;
}
