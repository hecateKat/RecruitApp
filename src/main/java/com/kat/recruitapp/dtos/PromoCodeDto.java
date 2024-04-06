package com.kat.recruitapp.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PromoCodeDto {

    public PromoCodeDto() {}

    @NotNull
    private String code;
}
