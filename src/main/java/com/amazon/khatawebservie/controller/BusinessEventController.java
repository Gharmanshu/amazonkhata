package com.amazon.khatawebservie.controller;

import com.amazon.khatawebservie.exceptions.KhataBadRequestException;
import com.amazon.khatawebservie.mapp.BusinessEventMapper;
import com.amazon.khatawebservie.model.BusinessEvent;
import com.amazon.khatawebservie.model.EventPayload;
import com.amazon.khatawebservie.repository.EventPayloadDAO;
import com.amazon.khatawebservie.services.EventPayloadHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API class
 * to use CRUD operations
 */
@RestController
@RequestMapping("/api")
public class BusinessEventController {

    /**
     *  Helper class to validate and transform input Business Event accordingly
     */
    private EventPayloadHelper eventPayloadHelper;

    /**
     * DAO to perform operation in database
     */
    private EventPayloadDAO eventPayloadDAO;
    /**
     *  Mapper class to map BusinessEvent and EventPayload
     */
    private BusinessEventMapper businessEventMapper;

    public BusinessEventController(EventPayloadHelper eventPayloadHelper, EventPayloadDAO eventPayloadDAO, BusinessEventMapper businessEventMapper) {
        this.eventPayloadHelper = eventPayloadHelper;
        this.eventPayloadDAO = eventPayloadDAO;
        this.businessEventMapper = businessEventMapper;
    }

    /**
     *  GET Method
     *  Output all eventPayload converted from all EventPayloadDTOs of Repository
     */
    @GetMapping("/events")
    public ResponseEntity<List<EventPayload>> findAll() {
        final List<EventPayload> eventPayloads = eventPayloadDAO.findAll();
        return ResponseEntity.ok(eventPayloads);
    }

    /**
     * PUT Method
     * @param businessEvent take business event as input
     *                      converting the business event to eventPayload
     *                      validate and transform eventPayload
     *                      converting the transformed eventPayload to eventPayloadDTO and save it in repository
     * @return ResponseEntity with eventPayload
     * @throws KhataBadRequestException if validation of eventPayload goes wrong
     */
    @PostMapping("/events")
    public ResponseEntity<EventPayload> create(@RequestBody BusinessEvent businessEvent) throws KhataBadRequestException {
        final EventPayload eventPayload = businessEventMapper.toEventPayload(businessEvent);
        eventPayloadHelper.validate(eventPayload);
        eventPayloadHelper.transform(eventPayload);
        eventPayloadDAO.save(eventPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventPayload);
    }

    /**
     * GET Method
     * @param idempotenceId is the id of EventPayloadDTO to be extracted
     *                      this eventPayloadDTO then converted into eventPayload
     * @return eventPayload with input idempotence Id
     */
    @GetMapping("event/{idempotenceId}")
    public ResponseEntity<?> findById(@PathVariable String idempotenceId) {
        final EventPayload eventPayload = eventPayloadDAO.findById(idempotenceId);
        return ResponseEntity.ok().body(eventPayload);
    }

    /**
     * PUT Method
     * @param idempotenceId is the id of eventPayloadDTO  which has to be updated
     * @param eventPayload updated eventPayload sent from API
     *                     again this eventPayload validated and transformed with updated property
     *                     updated eventPayload converted into eventPayloadDTO then inserted into repository
     * @return new eventPayload
     * @throws KhataBadRequestException if updated eventPayload is not valid
     */
    @PutMapping("/{idempotenceId}")
    public ResponseEntity<EventPayload> update(@PathVariable String idempotenceId, @RequestBody EventPayload eventPayload) throws KhataBadRequestException {
        eventPayload.setIdempotenceId(idempotenceId);
        eventPayloadHelper.validate(eventPayload);
        eventPayloadHelper.transform(eventPayload);
        eventPayloadDAO.save(eventPayload);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventPayload);
    }

    /**
     * DELETE Method
     * @param idempotenceId is the id of eventPayloadDTO that has to be deleted
     * @return Empty ResponseEntity
     */
    @DeleteMapping("event/{idempotenceId}")
    public ResponseEntity delete(@PathVariable String idempotenceId) {
        eventPayloadDAO.deleteById(idempotenceId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
