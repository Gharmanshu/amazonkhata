package com.amazon.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillingEntityDetails {

    @NonNull
    private String billingEntityId;
}