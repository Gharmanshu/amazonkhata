package com.amazon.khatawebservie.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * class of accounting event
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String countryCode;

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
    private String currencyCode;

    /**
     * amount of transaction
     */
    @NonNull
    private BigDecimal value;
}
