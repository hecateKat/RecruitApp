package com.kat.recruitapp.controllers;

import com.kat.recruitapp.dtos.TransactionDto;
import com.kat.recruitapp.services.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transaction")
@Api(tags = "Transaction Management")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping
    public String emptyPage(){
        return "aaa";
    }


    @PostMapping
    public TransactionDto createTransaction(){
        return transactionService.createTransaction();
    }
}
