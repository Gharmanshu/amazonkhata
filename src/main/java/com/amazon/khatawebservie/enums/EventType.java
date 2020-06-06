package com.amazon.khatawebservie.enums;

import com.amazon.khatawebservie.exceptions.KhataBadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enum of event type
 */
@AllArgsConstructor
@Getter
public enum EventType {
    CLICKS("CLICKS"),
    IMPRESSION("IMPRESSION"),
    ADJUSTMENT("ADJUSTMENT"),
    CHARGE("CHARGE"),
    REFUND("REFUND");

    private String eventTypeName;

    /**
     * Method to return instance of event type from given string event type name
     *
     * @param eventTypeName String representing event type name attribute of EventType
     * @return AppRespective enum value. If no value is found, then throws KhataBadRequestException
     */
    public static EventType ifExist(final String eventTypeName) throws KhataBadRequestException {
        for(EventType eventType : EventType.values()){
            if(eventType.eventTypeName.equals(eventTypeName)){
                return eventType;
            }
        }
        throw new KhataBadRequestException(eventTypeName+" is not a correct Event Type");
    }
}
