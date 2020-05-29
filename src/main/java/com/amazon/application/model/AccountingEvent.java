package com.amazon.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

/**
 * class of accounting event
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountingEvent {

    /**
     * type of event happened
     */
    @NonNull
    private String eventType;

    /**
     * country where event was generated
     */
    @NonNull
    private String country_code;

    /**
     * Id of event generated
     */
    @NonNull
    private String idempotenceId;

    /**
     * version of Id
     */
    @NonNull
    private Long idempotenceVersion;

    /**
     * marketplace where event happened
     */
    @NonNull
    private Long marketplaceId;

    /**
     * currency code of transaction
     */
    @NonNull
    private String currency_code;

    /**
     * amount of transaction
     */
    @NonNull
    private BigDecimal value;
}
