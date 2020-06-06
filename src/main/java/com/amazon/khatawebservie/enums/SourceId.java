package com.amazon.khatawebservie.enums;

import com.amazon.khatawebservie.exceptions.KhataBadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enum of source id
 */
@AllArgsConstructor
@Getter
public enum SourceId {
    IM_ADEPT("ADEPT"),
    IN_LEDGER("LEDGER");

    private String sourceIdName;

    /**
     * Method to return instance of source id from given string source id name
     *
     * @param sourceIdName String representing source id name attribute of SourceID
     * @return AppRespective enum value. If no value is found, then throws KhataBadRequestException
     */
    public static SourceId ifExist(final String sourceIdName) throws KhataBadRequestException {
        for(SourceId sourceId:SourceId.values()){
            if(sourceId.sourceIdName.equals(sourceIdName)){
                return sourceId;
            }
        }
        throw new KhataBadRequestException(sourceIdName+" is not a correct SourceId");
    }
}
