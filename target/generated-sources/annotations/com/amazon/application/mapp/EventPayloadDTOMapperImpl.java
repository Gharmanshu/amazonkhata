package com.amazon.application.mapp;

import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-27T23:51:01+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class EventPayloadDTOMapperImpl implements EventPayloadDTOMapper {

    @Override
    public EventPayloadDTO toEventPayloadDTO(EventPayload eventPayload) {
        if ( eventPayload == null ) {
            return null;
        }

        EventPayloadDTO eventPayloadDTO = new EventPayloadDTO();

        eventPayloadDTO.setIdempotenceId( eventPayload.getIdempotenceId() );
        eventPayloadDTO.setIdempotenceVersion( eventPayload.getIdempotenceVersion() );
        eventPayloadDTO.setMarketplaceId( eventPayload.getMarketplaceId() );
        eventPayloadDTO.setAmount( eventPayload.getAmount() );
        eventPayloadDTO.setBusinessEventString( eventPayload.getBusinessEventString() );
        eventPayloadDTO.setAccountingEvent( eventPayload.getAccountingEvent() );
        eventPayloadDTO.setFolioId( eventPayload.getFolioId() );
        eventPayloadDTO.setFailureMessage( eventPayload.getFailureMessage() );
        eventPayloadDTO.setFailureStatus( eventPayload.getFailureStatus() );
        eventPayloadDTO.setProcessAfterTime( eventPayload.getProcessAfterTime() );
        eventPayloadDTO.setRetryCount( eventPayload.getRetryCount() );
        eventPayloadDTO.setInProcessStatus( eventPayload.getInProcessStatus() );
        eventPayloadDTO.setCreationTime( eventPayload.getCreationTime() );
        eventPayloadDTO.setExpirationTime( eventPayload.getExpirationTime() );
        eventPayloadDTO.setRecordVersion( eventPayload.getRecordVersion() );

        return eventPayloadDTO;
    }
}
