package com.amazon.khatawebservie.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventPayload {

    @NonNull
    private String idempotenceId;

    @NonNull
    private Long idempotenceVersion;

    @NonNull
    private String businessEventString;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private Long marketplaceId;

    /**
     * converted accounting event
     */
    private String accountingEvent;

    /**
     * Folio id will be associated while transformation of the event
     * from business event to accounting event
     */
    private String folioId;

    /**
     * Failure message if any
     */
    private String failureMessage;

    /**
     * Failure status (soft or hard failure)
     */
    private String failureStatus;

    /**
     * process after time for an event in case of failures
     */
    private LocalDateTime processAfterTime;

    /**
     * Retry count of this event, in case of failures
     */
    @NonNull
    private int retryCount;

    /**
     * This attribute will be set only for events when they are in process by a lambda, at first initial insertion.
     */
    private String inProcessStatus;

    /**
     * Creation time for this event
     */
    private LocalDateTime creationTime;
    /**
     * expiration time of this event in DB
     */
    private LocalDateTime expirationTime;
    /**
     * Version of this event in DB. Helpful with optimistic locking
     */
    @NonNull
    private Long recordVersion;



}
