package com.amazon.khatawebservie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enum of marketplace
 */
@AllArgsConstructor
@Getter
public enum Marketplace {
    UNITED_STATES("US"),
    INDIA("IN"),
    UNITED_KINGDOM("UK"),
    DENMARK("DE"),
    FRANCE("FR"),
    JAPAN("JP"),
    END("INVALID");

    private String marketplaceName;

    /**
     * Method to return instance of marketplace from given string marketplace name
     *
     * @param marketplaceName String representing marketplace name attribute of Marketplace
     * @return AppRespective enum value. If no value is found, then the INVALID enum value (END)
     */
    public static Marketplace ifExist(final String marketplaceName){
        for(Marketplace marketplace : Marketplace.values()){
            if(marketplace.marketplaceName.equals(marketplaceName)){
                return marketplace;
            }
        }
        return Marketplace.END;
    }
}
