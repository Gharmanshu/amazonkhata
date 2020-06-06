package com.amazon.khatawebservie.repository;

import com.amazon.khatawebservie.model.EventPayload;
import com.amazon.khatawebservie.model.EventPayloadDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Data access Object interface
 * To perfom CRUD operations in database
 */
@Component
public interface EventPayloadDAO {

    /**
     * converting all event payload DTO to event payload in database
     * @return list of event payloads
     */
    public List<EventPayload> findAll();

    /**
     * Inserting event payload DTO to database after converting from event payload
     * @param eventPayload to be inserted in databse
     * @return newlt created evented payload
     */
    public EventPayloadDTO save(EventPayload eventPayload);

    /**
     * find event payload DTO by it id and convert it into event payload
     * @param idempotenceId of event payload DTO
     * @return event Payload with the passed id
     */
    public EventPayload findById(String idempotenceId);

    /**
     * delete entry from table
     * @param idempotenceId of event payload DTO to be deleted from database
     */
    public void deleteById(String idempotenceId);
}
