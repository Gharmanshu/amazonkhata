package com.amazon.application.controller;

import com.amazon.application.mapp.BusinessEventMapper;
import com.amazon.application.mapp.EventPayloadDTOMapper;
import com.amazon.application.model.BusinessEvent;
import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import com.amazon.application.repository.BusinessEventRepository;
import com.amazon.application.services.EventPayloadHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BusinessEventController {
    /*@Autowired
    private BusinessEventAndEventPayloadMapper businessEventMapper;*/

    /**
     * to do operations in repository
     */
    @Autowired
    private EventPayloadHelper eventPayloadHelper;

    @Autowired
    private BusinessEventRepository businessEventRepository;

    @GetMapping("/events")
    public ResponseEntity<List<EventPayloadDTO>> findAll() {
        return ResponseEntity.ok(businessEventRepository.findAll());
    }

    @PostMapping("/events")
    public ResponseEntity<EventPayload> create(@RequestBody BusinessEvent businessEvent) throws JsonProcessingException {
        System.out.println(businessEvent);
        EventPayload eventPayload = BusinessEventMapper.INSTANCE.toEventPayload(businessEvent);
        eventPayloadHelper.validate(eventPayload);
        eventPayloadHelper.transform(eventPayload);
        EventPayloadDTO eventPayloadDTO = EventPayloadDTOMapper.INSTANCE.toEventPayloadDTO(eventPayload);
        businessEventRepository.save(eventPayloadDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventPayload);
    }

    @GetMapping("event/{idempotenceId}")
    public ResponseEntity<?> findById(@PathVariable String idempotenceId) {
        Optional<EventPayloadDTO> eventPayloadDTO = businessEventRepository.findById(idempotenceId);
        return eventPayloadDTO.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{idempotenceId}")
    public ResponseEntity<EventPayloadDTO> update(@PathVariable String idempotenceId, @RequestBody EventPayloadDTO eventPayloadDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);

        productService.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("event/{idempotenceId}")
    public ResponseEntity delete(@PathVariable String idempotenceId) {
        businessEventRepository.deleteById(idempotenceId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
