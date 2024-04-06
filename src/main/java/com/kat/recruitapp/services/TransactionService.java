package com.kat.recruitapp.services;

import com.kat.recruitapp.dtos.TransactionDto;
import com.kat.recruitapp.dtos.TransactionRequest;

public interface TransactionService {

    TransactionDto createTransaction(TransactionRequest request);
}
