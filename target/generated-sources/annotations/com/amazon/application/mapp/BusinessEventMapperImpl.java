package com.amazon.application.mapp;

import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-27T23:53:44+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class BusinessEventMapperImpl implements BusinessEventMapper {

    @Override
    public EventPayload toEventPayload(BusinessEvent businessEvent) {
        if ( businessEvent == null ) {
            return null;
        }

        EventPayload eventPayload = new EventPayload();

        return eventPayload;
    }
}
