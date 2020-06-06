package com.amazon.khatawebservie.services;

import com.amazon.khatawebservie.enums.*;
import com.amazon.khatawebservie.exceptions.KhataBadRequestException;
import com.amazon.khatawebservie.mapp.AccountingEventMapper;
import com.amazon.khatawebservie.model.AccountingEvent;
import com.amazon.khatawebservie.model.BusinessEvent;
import com.amazon.khatawebservie.model.EventPayload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * service class to validate and transform event payload
 */
@Service
public class EventPayloadHelper {

    @Autowired
    private AccountingEventMapper accountingEventMapper;

    /**
     * vlidate the event payload before inserting into DB
     * @param eventPayload that has to be validated
     * @throws KhataBadRequestException if invalid
     */
    public void validate(EventPayload eventPayload) throws KhataBadRequestException {
        Gson gson = new Gson();
        final BusinessEvent businessEvent = gson.fromJson(eventPayload.getBusinessEventString(),BusinessEvent.class);
        SourceId.ifExist(businessEvent.getSourceDetails().getSourceId());
        EventType.ifExist(businessEvent.getEventDetails().getEventType());
    }

    /**
     * transfrom event payload according to some property
     * @param eventPayload that has to be transformed
     */
    public void transform(EventPayload eventPayload) {
        Gson gson = new Gson();
        final BusinessEvent businessEvent = gson.fromJson(eventPayload.getBusinessEventString(),BusinessEvent.class);
        Map<String,String> additional = businessEvent.getAdditionalDetails();
        FailureMessageGenerator errorGenerator = new FailureMessageGenerator();
        String failureMsg = new String("");
        for (Map.Entry<String, String> entry : additional.entrySet()) {
            String errorMessage = errorGenerator.generateMessage(entry.getKey(),entry.getValue());
            failureMsg = errorMessage.equals("INVALID") ? failureMsg.concat(entry.getKey()+"|") : failureMsg.concat("") ;
        }
        failureMsg = errorGenerator.generateMessage("currency",businessEvent.getAmountDetails().getCurrency()).equals("INVALID") ? failureMsg.concat("currency|") : failureMsg.concat("") ;
        failureMsg = errorGenerator.generateMessage("currency",businessEvent.getAmountDetails().getLocalCurrency()).equals("INVALID") ? failureMsg.concat("local_currency|") : failureMsg.concat("") ;
        eventPayload.setFailureMessage(failureMsg);
        final String status = eventPayload.getFailureMessage().equals("") ? "false" : "true" ;
        eventPayload.setFailureStatus(status);
        eventPayload.setRetryCount(eventPayload.getRetryCount()+1);
        if(eventPayload.getFailureStatus().equals("false")){
            AccountingEvent accountingEvent = accountingEventMapper.toAccountingEvent(eventPayload,businessEvent);
            Gson account = new GsonBuilder().setPrettyPrinting().create();
            final String accountingEventString = account.toJson(accountingEvent);
            eventPayload.setAccountingEvent(accountingEventString);
            eventPayload.setFolioId("FolioId|"+eventPayload.getIdempotenceId());
        }
    }
}
