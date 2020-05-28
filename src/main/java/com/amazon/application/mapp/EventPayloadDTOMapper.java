package com.amazon.application.mapp;

import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventPayloadDTOMapper {
    EventPayloadDTOMapper INSTANCE = Mappers.getMapper(EventPayloadDTOMapper.class);
    EventPayloadDTO toEventPayloadDTO(EventPayload eventPayload);
    //EventPayload toEventPayload(EventPayloadDTO eventPayloadDTO);
}
