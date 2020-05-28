package com.amazon.application.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessEvent {

    private SourceDetails sourceDetails;


    private EventDetails eventDetails;


    private AmountDetails amountDetails;


    private BillingEntityDetails billingEntityDetails;


    private Map<String, String> additionalDetails;


}
