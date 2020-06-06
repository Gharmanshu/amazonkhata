package com.amazon.khatawebservie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * class of billing entity details
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillingEntityDetails {

    /**
     * id of billing entity
     */
    @NonNull
    private String billingEntityId;
}