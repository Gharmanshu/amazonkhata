package com.amazon.khatawebservie.mapp;

import com.amazon.khatawebservie.model.BusinessEvent;
import com.amazon.khatawebservie.model.EventPayload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mapper class of Business Event and Event Payload
 */
@Component
public class BusinessEventMapper {

        /**
         * convert business event to eventPayload
         * @param businessEvent input business event
         * @return newly generated event payload
         */
    public EventPayload toEventPayload(@NonNull BusinessEvent businessEvent) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(businessEvent);
            return EventPayload.builder()
                        .idempotenceId(businessEvent.getEventDetails().getEventType()+"|"+
                                businessEvent.getEventDetails().getParentId()+"|"+
                                businessEvent.getEventDetails().getEventId()+"|"+
                                businessEvent.getEventDetails().getMarketplaceId())
                        .idempotenceVersion(1L)
                        .businessEventString(jsonOutput)
                        .amount(businessEvent.getAmountDetails().getLocalValue())
                        .marketplaceId(businessEvent.getEventDetails().getMarketplaceId())
                        .accountingEvent("")
                        .folioId("")
                        .failureMessage("")
                        .failureStatus("")
                        .processAfterTime(LocalDateTime.now())
                        .retryCount(-1)
                        .inProcessStatus("YES")
                        .expirationTime(LocalDateTime.now())
                        .recordVersion(1L)
                        .creationTime(businessEvent.getEventDetails().getActivityDate())
                        .build();
        }
}
