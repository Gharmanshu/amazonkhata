package com.amazon.application.services;

import com.amazon.application.enums.Channel;
import com.amazon.application.enums.Currency;
import com.amazon.application.enums.Marketplace;
import com.amazon.application.enums.ProgramID;
import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EventPayloadHelper {
    public void validate(EventPayload eventPayload){
        Gson gson = new Gson();
        BusinessEvent businessEvent = gson.fromJson(eventPayload.getBusinessEventString(),BusinessEvent.class);
        Map<String,String> additional = businessEvent.getAdditionalDetails();
        additional.forEach((key,value)-> {
            int flag=0;
            switch(key) {
                case "channel":
                    for(Channel c: Channel.values()){
                        if(c.name().equals(value)){
                           flag=1;
                        }
                    }
                    if(flag ==0) eventPayload.setFailureMessage(eventPayload.getFailureMessage()+"|"+"channel");
                    break;
                case "site":
                    for(Marketplace m: Marketplace.values()){
                        if(m.name().equals(value)){
                            flag=1;
                        }
                    }
                    if(flag==0) eventPayload.setFailureMessage(eventPayload.getFailureMessage()+"|"+"marketplace");
                    break;
                case "programId":
                    for(int i=0;i< ProgramID.ids.length;i++){
                        if(ProgramID.ids[i].toString().equals(value)){
                            flag=1;
                        }
                    }
                    if(flag==0) eventPayload.setFailureMessage(eventPayload.getFailureMessage()+"|"+"programId");
                    break;
                default:break;
            }
        });
        int flag=0;
        for(Currency c : Currency.values()){
           if(c.name().equals(businessEvent.getAmountDetails().getCurrency())){
               flag=1;
           }
        }
        if(flag==0) eventPayload.setFailureMessage(eventPayload.getFailureMessage()+"|"+"currency");
        flag=0;
        for(Currency c : Currency.values()){
            if(c.name().equals(businessEvent.getAmountDetails().getLocalCurrency())){
                flag=1;
            }
        }
        if(flag==0) eventPayload.setFailureMessage(eventPayload.getFailureMessage()+"|"+"localCurrency");
    }

    public void transform(EventPayload eventPayload) {
        if(eventPayload.getFailureMessage()==""){
            eventPayload.setFailureStatus("false");
        }
        else {
            eventPayload.setFailureStatus("true");
        }
    }
}
