package com.amazon.application.mapp;

import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T17:14:37+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class EventPayloadDTOMapperImpl implements EventPayloadDTOMapper {

    @Override
    public EventPayload toEventPayload(EventPayloadDTO eventPayloadDTO) {
        if ( eventPayloadDTO == null ) {
            return null;
        }

        EventPayload eventPayload = new EventPayload();

        eventPayload.setIdempotenceId( eventPayloadDTO.getIdempotenceId() );
        eventPayload.setIdempotenceVersion( eventPayloadDTO.getIdempotenceVersion() );
        eventPayload.setBusinessEventString( eventPayloadDTO.getBusinessEventString() );
        eventPayload.setAmount( eventPayloadDTO.getAmount() );
        eventPayload.setMarketplaceId( eventPayloadDTO.getMarketplaceId() );
        eventPayload.setAccountingEvent( eventPayloadDTO.getAccountingEvent() );
        eventPayload.setFolioId( eventPayloadDTO.getFolioId() );
        eventPayload.setFailureMessage( eventPayloadDTO.getFailureMessage() );
        eventPayload.setFailureStatus( eventPayloadDTO.getFailureStatus() );
        eventPayload.setProcessAfterTime( eventPayloadDTO.getProcessAfterTime() );
        eventPayload.setRetryCount( eventPayloadDTO.getRetryCount() );
        eventPayload.setInProcessStatus( eventPayloadDTO.getInProcessStatus() );
        eventPayload.setCreationTime( eventPayloadDTO.getCreationTime() );
        eventPayload.setExpirationTime( eventPayloadDTO.getExpirationTime() );
        eventPayload.setRecordVersion( eventPayloadDTO.getRecordVersion() );

        return eventPayload;
    }

    @Override
    public List<EventPayload> toListEventPayload(List<EventPayloadDTO> eventPayloadDTOList) {
        if ( eventPayloadDTOList == null ) {
            return null;
        }

        List<EventPayload> list = new ArrayList<EventPayload>( eventPayloadDTOList.size() );
        for ( EventPayloadDTO eventPayloadDTO : eventPayloadDTOList ) {
            list.add( toEventPayload( eventPayloadDTO ) );
        }

        return list;
    }

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
