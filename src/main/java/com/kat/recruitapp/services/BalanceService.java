package com.kat.recruitapp.services;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.dtos.UserDto;

import java.util.UUID;

public interface BalanceService {

    BalanceDto save(BalanceDto balance);

    BalanceDto update(UUID id, BalanceDto balanceDto);

    BalanceDto getBalanceByUsername(UserDto userDto);
}
