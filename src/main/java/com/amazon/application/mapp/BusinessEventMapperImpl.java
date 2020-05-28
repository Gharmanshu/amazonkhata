package com.amazon.application.mapp;

import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class BusinessEventMapperImpl implements BusinessEventMapper {
    @Override
    public EventPayload toEventPayload(BusinessEvent businessEvent) {

            EventPayload eventPayload = new EventPayload();

            eventPayload.setIdempotenceId(businessEvent.getEventDetails().getEventType()+"|"+
                    businessEvent.getEventDetails().getParentId()+"|"+
                    businessEvent.getEventDetails().getEventId()+"|"+
                    businessEvent.getEventDetails().getMarketplaceId());

            eventPayload.setIdempotenceVersion(1L);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(businessEvent);
            eventPayload.setBusinessEventString(jsonOutput);

            eventPayload.setAmount(businessEvent.getAmountDetails().getLocalValue());

            eventPayload.setMarketplaceId(businessEvent.getEventDetails().getMarketplaceId());

            eventPayload.setAccountingEvent("");

            eventPayload.setFolioId("");

            eventPayload.setFailureMessage("");

            eventPayload.setFailureStatus("");

            eventPayload.setProcessAfterTime(LocalDateTime.now());

            eventPayload.setRetryCount(-1);

            eventPayload.setInProcessStatus("YES");

            eventPayload.setExpirationTime(LocalDateTime.now());

            eventPayload.setRecordVersion(1L);

            return eventPayload;
        }
}
