package com.kat.recruitapp.controllers;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.dtos.PromoCodeDto;
import com.kat.recruitapp.services.BalanceService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/balance")
@Api(tags = "Balance Management")
@Slf4j
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping(path = "/add")
    public BalanceDto addUserBalance(@Valid @RequestBody PromoCodeDto code) {
        return balanceService.addUserBalance(code);
    }
}
