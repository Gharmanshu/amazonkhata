package com.amazon.application.mapp;

import com.amazon.application.model.AccountingEvent;
import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
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
        AccountingEvent accountingEvent = new AccountingEvent();
        accountingEvent.setEventType(businessEvent.getEventDetails().getEventType());
        accountingEvent.setCountry_code(businessEvent.getAdditionalDetails().get("marketplace"));
        accountingEvent.setIdempotenceId(eventPayload.getIdempotenceId());
        accountingEvent.setIdempotenceVersion(eventPayload.getIdempotenceVersion());
        accountingEvent.setMarketplaceId(eventPayload.getMarketplaceId());
        accountingEvent.setCurrency_code(businessEvent.getAmountDetails().getCurrency());
        accountingEvent.setValue(eventPayload.getAmount());
        return accountingEvent;
    }
}
