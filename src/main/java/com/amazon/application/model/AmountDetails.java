package com.amazon.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AmountDetails {
    private String currency;

    private BigDecimal value;

    private String localCurrency;

    private BigDecimal localValue;

}
