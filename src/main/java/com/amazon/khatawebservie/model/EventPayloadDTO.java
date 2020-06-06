package com.amazon.khatawebservie.model;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class EventPayloadDTO {

    /**
     * Idempotence id is the partition key of the event payload table
     */
    @NonNull
    @Id
    private String idempotenceId;

    /**
     * Idempotence version is the sort key of the event payload table
     */
    @NonNull
    private Long idempotenceVersion;

    /**
     * Marketplace id of the event
     */
    @NonNull
    private Long marketplaceId;

    /**
     * $ value of the event
     */
    @NonNull
    private BigDecimal amount;

    /**
     * Business event payload received from SQS
     */
    @NonNull
    @Lob
    private String businessEventString;
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
     * This attribute will be set only for failed events while processing
     */
    private String failureStatus;

    private LocalDateTime processAfterTime;

    /**
     * Retry count of this event, i.e. how many times this event has been attempted for processing.
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
     * Update time for this event
     */
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    /**
     * Epoch seconds denoting expiration time of this event in DB. Serves purpose of TTL.
     */
    private LocalDateTime expirationTime;

    /**
     * Version of this event in DDB to be used for optimistic locking
     */
    @NonNull
    private Long recordVersion;
}