package com.kat.recruitapp.controllers;

import com.kat.recruitapp.dtos.TransactionDto;
import com.kat.recruitapp.dtos.TransactionRequest;
import com.kat.recruitapp.services.TransactionService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transaction")
@Api(tags = "Transaction Management")
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionDto performTransfer(@Valid @RequestBody TransactionRequest request) {
        return transactionService.createTransaction(request);
    }
}
