package com.amazon.application.mapp;

import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessEventMapper {
    BusinessEventMapper INSTANCE = Mappers.getMapper(BusinessEventMapper.class);

    EventPayload toEventPayload(BusinessEvent businessEvent);
}
