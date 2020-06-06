package com.amazon.khatawebservie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountingDetails {

    private String channel;
    private String programId;
    private String site;
    private Long glProductGroup;
}
