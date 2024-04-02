package com.kat.recruitapp.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transaction")
@Api(tags = "Transaction Management")
public class TransactionController {

    @GetMapping
    public String emptyPage(){
        return "aaa";
    }
}
