package com.amazon.khatawebservie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enum of Currency code
 */
@AllArgsConstructor
@Getter
public enum Currency {
    DOLLAR("USD"),
    RUPEES("INR"),
    POUND("GBP"),
    EURO("EUR"),
    JAP_YEN("JPY"),
    END("INVALID");

    private String currencyInput;

    /**
     * Method to return instance of Currency from given string currency input
     *
     * @param currencyInput String representing currency input attribute of Currency
     * @return AppRespective enum value. If no value is found, then the INVALID enum value (END)
     */
    public static Currency ifExist(final String currencyInput) {

        for(Currency currency : Currency.values()) {
            if(currency.currencyInput.equals(currencyInput)){
                return currency;
            }
        }
        return Currency.END;
    }
}
