package com.amazon.khatawebservie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * class of source details of business event
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SourceDetails {

    @NonNull
    private String sourceId;
}

