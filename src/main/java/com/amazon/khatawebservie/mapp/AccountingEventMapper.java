package com.amazon.khatawebservie.mapp;

import com.amazon.khatawebservie.model.AccountingEvent;
import com.amazon.khatawebservie.model.BusinessEvent;
import com.amazon.khatawebservie.model.EventPayload;
import lombok.NonNull;
import org.springframework.stereotype.Component;

/**
 * Mapper class of Accounting Event and Event Payload
 */
@Component
public class AccountingEventMapper {

    /**
     * convert eventpayload to accounting event
     * @param eventPayload reference eventPayload
     * @param businessEvent of particulae eventPayload
     * @return newly generated accounting event
     */
    public AccountingEvent toAccountingEvent(@NonNull EventPayload eventPayload, @NonNull BusinessEvent businessEvent){
        return AccountingEvent.builder()
        .eventType(businessEvent.getEventDetails().getEventType())
        .countryCode(businessEvent.getAdditionalDetails().get("marketplace"))
        .idempotenceId(eventPayload.getIdempotenceId())
        .idempotenceVersion(eventPayload.getIdempotenceVersion())
        .marketplaceId(eventPayload.getMarketplaceId())
        .currencyCode(businessEvent.getAmountDetails().getCurrency())
        .value(eventPayload.getAmount())
        .build();
    }
}
