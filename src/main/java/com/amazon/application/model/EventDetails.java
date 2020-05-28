package com.amazon.application.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDetails {
    @NonNull
    private String eventId;

    @NonNull
    private String parentId;

    @NonNull
    private LocalDateTime activityDate;

    @NonNull
    private String eventType;

    @NonNull
    private Long marketplaceId;
}
