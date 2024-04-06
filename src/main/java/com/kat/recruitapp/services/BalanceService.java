package com.kat.recruitapp.services;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.dtos.PromoCodeDto;

public interface BalanceService {

    BalanceDto addUserBalance(PromoCodeDto code);

}
