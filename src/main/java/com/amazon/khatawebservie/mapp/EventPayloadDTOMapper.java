package com.amazon.khatawebservie.mapp;

import com.amazon.khatawebservie.model.EventPayload;
import com.amazon.khatawebservie.model.EventPayloadDTO;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * mapper interface of event payload and event payload DTO
 */
@Component
public class EventPayloadDTOMapper {

    /**
     * convert event payload DTO to event Payload
     * @param eventPayloadDTO input
     * @return newly generated event payload
     */
    public EventPayload toEventPayload(@NonNull EventPayloadDTO eventPayloadDTO){

        return EventPayload.builder()
                .idempotenceId(eventPayloadDTO.getIdempotenceId())
                .idempotenceVersion(eventPayloadDTO.getIdempotenceVersion())
                .businessEventString(eventPayloadDTO.getBusinessEventString())
                .amount(eventPayloadDTO.getAmount())
                .marketplaceId(eventPayloadDTO.getMarketplaceId())
                .accountingEvent(eventPayloadDTO.getAccountingEvent())
                .folioId(eventPayloadDTO.getFolioId())
                .failureMessage(eventPayloadDTO.getFailureMessage())
                .failureStatus(eventPayloadDTO.getFailureStatus())
                .processAfterTime(eventPayloadDTO.getProcessAfterTime())
                .retryCount(eventPayloadDTO.getRetryCount())
                .inProcessStatus(eventPayloadDTO.getInProcessStatus())
                .creationTime(eventPayloadDTO.getCreationTime())
                .expirationTime(eventPayloadDTO.getExpirationTime())
                .recordVersion(eventPayloadDTO.getRecordVersion())
                .build();

    }

    /**
     * convert list of event payload DTO to list of event payload
     * @param eventPayloadDTOList input list of event payload DTO
     * @return list of newly created eventPayloads
     */
    public List<EventPayload> toListEventPayload(@NonNull List<EventPayloadDTO> eventPayloadDTOList){
        List<EventPayload> eventPayloadList =new ArrayList<EventPayload>();
        eventPayloadDTOList.forEach(eventPayloadDTO -> {
            EventPayload eventPayload = toEventPayload(eventPayloadDTO);
            eventPayloadList.add(eventPayload);
        });
        return eventPayloadList;
    }

    /**
     * convert Event payload to event payload DTO
     * @param eventPayload input event payload DTO
     * @return newly created event payload DTO
     */
    public EventPayloadDTO toEventPayloadDTO(EventPayload eventPayload)
    {
        return EventPayloadDTO.builder()
                .idempotenceId(eventPayload.getIdempotenceId())
                .idempotenceVersion(eventPayload.getIdempotenceVersion())
                .businessEventString(eventPayload.getBusinessEventString())
                .amount(eventPayload.getAmount())
                .marketplaceId(eventPayload.getMarketplaceId())
                .accountingEvent(eventPayload.getAccountingEvent())
                .folioId(eventPayload.getFolioId())
                .failureMessage(eventPayload.getFailureMessage())
                .failureStatus(eventPayload.getFailureStatus())
                .processAfterTime(eventPayload.getProcessAfterTime())
                .retryCount(eventPayload.getRetryCount())
                .inProcessStatus(eventPayload.getInProcessStatus())
                .creationTime(eventPayload.getCreationTime())
                .expirationTime(eventPayload.getExpirationTime())
                .recordVersion(eventPayload.getRecordVersion())
                .build();
    }
}
