package com.amazon.khatawebservie.model;
import lombok.*;

import java.util.Map;

/**
 * class of business event
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusinessEvent {

    /**
     * source details from which event id  generated
     */
    @NonNull
    private SourceDetails sourceDetails;

    /**
     * event details of business event
     */
    @NonNull
    private EventDetails eventDetails;

    /**
     * amount details of business event
     */
    @NonNull
    private AmountDetails amountDetails;

    /**
     * billing entity details of business event
     */
    @NonNull
    private BillingEntityDetails billingEntityDetails;

    /**
     * additional details of business event like marketplace,channel etc
     */
    @NonNull
    private Map<String, String> additionalDetails;


}
