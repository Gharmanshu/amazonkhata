package com.amazon.khatawebservie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enum of Program id
 */
@AllArgsConstructor
@Getter
public enum ProgramID {
    N1("101"),
    N2("102"),
    N3("103"),
    N4("104"),
    N5("105"),
    N6("106"),
    N7("107"),
    N8("108"),
    N9("201"),
    N10("202"),
    END("INVALID");

    private String programIdName;

    /**
     * Method to return instance of program id from given string program id name
     *
     * @param programIdName String representing program id name attribute of ProgramID
     * @return AppRespective enum value. If no value is found, then the INVALID enum value (END)
     */
    public static ProgramID ifExist(final String programIdName){
        for(ProgramID programID : ProgramID.values()){
            if(programID.programIdName.equals(programIdName)){
                return programID;
            }
        }
        return ProgramID.END;
    }

}
