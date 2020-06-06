package com.amazon.khatawebservie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * class of event details of business event
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDetails {

    /**
     * Id of event
     */
    @NonNull
    private String eventId;

    /**
     * parent id
     */
    @NonNull
    private String parentId;

    /**
     * activity date of event
     */
    @NonNull
    @JsonIgnore
    private LocalDateTime activityDate = LocalDateTime.now();

    /**
     * type of event happened
     */
    @NonNull
    private String eventType;

    /**
     * marketplace if of event
     */
    @NonNull
    private Long marketplaceId;
}
