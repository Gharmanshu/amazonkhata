package com.amazon.khatawebservie.services;

import com.amazon.khatawebservie.enums.Channel;
import com.amazon.khatawebservie.enums.Currency;
import com.amazon.khatawebservie.enums.Marketplace;
import com.amazon.khatawebservie.enums.ProgramID;

/**
 * class to generate failure message for event payload
 */
public class FailureMessageGenerator {

    /**
     *
     * @param key of additional details of business event
     * @param value value according to the key
     * @return the whether the value is valid according to the key by checking in enum class
     */
    public String generateMessage(final String key, final String value) {
        String status = new String("");
        switch(key){
            case "programId":
                ProgramID programID = ProgramID.ifExist(value);
                status=status.concat(programID.getProgramIdName());
                break;
            case "channel" :
                Channel channel = Channel.ifExist(value);
                status=status.concat(channel.getChannelName());
                //System.out.println("channel = "+channel.getChannelName());
                break;
            case "marketplace":
                Marketplace marketplace = Marketplace.ifExist(value);
                status=status.concat(marketplace.getMarketplaceName());
                break;
            case "currency":
                Currency currency = Currency.ifExist(value);
                status=status.concat(currency.getCurrencyInput());
                break;
            default:
                status=status.concat("INVALID");
                break;
        }
        return status;
    }
}
