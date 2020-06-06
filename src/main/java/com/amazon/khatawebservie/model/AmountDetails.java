package com.amazon.khatawebservie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * class of amount details
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AmountDetails {

    /**
     * currency code of event generated
     */
    @NonNull
    private String currency;

    /**
     * amount according to currency code
     */
    @NonNull
    private BigDecimal value;

    /**
     *  payment currency code
     */
    @NonNull
    private String localCurrency;

    /**
     * amount according to local Currency
     */
    @NonNull
    private BigDecimal localValue;

}
