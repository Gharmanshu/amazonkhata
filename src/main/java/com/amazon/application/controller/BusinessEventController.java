package com.amazon.application.controller;

import com.amazon.application.exceptions.KhataBadRequestException;
import com.amazon.application.mapp.BusinessEventMapper;
import com.amazon.application.mapp.EventPayloadDTOMapper;
import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import com.amazon.application.repository.BusinessEventRepository;
import com.amazon.application.services.EventPayloadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private EventPayloadHelper eventPayloadHelper;

    /**
     *  Mapper class to map BusinessEvent and EventPayload
     */
    @Autowired
    private BusinessEventMapper businessEventMapper;

    /**
     *  Repository to add input events in format of EventPayloadDTO
     */
    @Autowired
    private BusinessEventRepository businessEventRepository;

    /**
     *  GET Method
     *  Output all eventPayload converted from all EventPayloadDTOs of Repository
     */
    @GetMapping("/events")
    public ResponseEntity<List<EventPayload>> findAll() {
        List<EventPayloadDTO> eventPayloadDTOS = businessEventRepository.findAll();
        List<EventPayload> eventPayloads = EventPayloadDTOMapper.INSTANCE.toListEventPayload(eventPayloadDTOS);
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
        System.out.println(businessEvent);
        EventPayload eventPayload = businessEventMapper.toEventPayload(businessEvent);
        eventPayloadHelper.validate(eventPayload);
        eventPayloadHelper.transform(eventPayload);
        EventPayloadDTO eventPayloadDTO = EventPayloadDTOMapper.INSTANCE.toEventPayloadDTO(eventPayload);
        businessEventRepository.save(eventPayloadDTO);
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
        Optional<EventPayloadDTO> eventPayloadDTO = businessEventRepository.findById(idempotenceId);
        EventPayload eventPayload = EventPayloadDTOMapper.INSTANCE.toEventPayload(eventPayloadDTO.get());
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
        EventPayloadDTO eventPayloadDTO = EventPayloadDTOMapper.INSTANCE.toEventPayloadDTO(eventPayload);
        businessEventRepository.save(eventPayloadDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventPayload);
    }

    /**
     * DELETE Method
     * @param idempotenceId is the id of eventPayloadDTO that has to be deleted
     * @return Empty ResponseEntity
     */
    @DeleteMapping("event/{idempotenceId}")
    public ResponseEntity delete(@PathVariable String idempotenceId) {
        businessEventRepository.deleteById(idempotenceId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
