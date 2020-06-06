package com.amazon.khatawebservie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CheckFailure {
    MARKETPLACE("marketplace"),
    PROGRAM_ID("programId"),
    CHANNEL("channel"),
    CURRENCY("currency"),
    END("NOT");

    private String checkFailureKey;

    public static CheckFailure ifExist(final String checkFailureKey){
        for(CheckFailure checkFailure : CheckFailure.values()){
            if(checkFailure.checkFailureKey.equals(checkFailureKey)){
                return checkFailure;
            }
        }
        return CheckFailure.END;
    }
}
