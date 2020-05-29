package com.amazon.application.mapp;

import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * mapper interface of event payload and event payload DTO
 */
@Mapper
public interface EventPayloadDTOMapper {
    EventPayloadDTOMapper INSTANCE = Mappers.getMapper(EventPayloadDTOMapper.class);

    /**
     * convert event payload DTO to event Payload
     * @param eventPayloadDTO input
     * @return newly generated event payload
     */
    public EventPayload toEventPayload(EventPayloadDTO eventPayloadDTO);

    /**
     * convert list of event payload DTO to list of event payload
     * @param eventPayloadDTOList input list of event payload DTO
     * @return list of newly created eventPayloads
     */
    public List<EventPayload> toListEventPayload(List<EventPayloadDTO> eventPayloadDTOList);

    /**
     * convert Event payload to event payload DTO
     * @param eventPayload input event payload DTO
     * @return newly created event payload DTO
     */
    public EventPayloadDTO toEventPayloadDTO(EventPayload eventPayload);
}
