package com.amazon.khatawebservie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Enum for channel name
 */
@AllArgsConstructor
@Getter
public enum Channel {
    C1("MFN"),
    C2("FBA"),
    C3("RTL"),
    C4("PANTRY"),
    END("INVALID");

    private String channelName;

    /**
     * Method to return instance of Channel from given string channel name
     *
     * @param channelName String representing channel name attribute of Channel
     * @return AppRespective enum value. If no value is found, then the INVALID enum value (END)
     */
    public static Channel ifExist(final String channelName) {
        for(Channel channel : Channel.values()){
            if(channel.channelName.equals(channelName)){
                return channel;
            }
        }
        return Channel.END;
    }
}
