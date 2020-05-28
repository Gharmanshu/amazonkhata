package com.amazon.application.services;

import com.amazon.application.mapp.EventPayloadDTOMapper;
import com.amazon.application.model.EventPayload;
import com.amazon.application.model.EventPayloadDTO;
import com.amazon.application.repository.BusinessEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhataDAO {

   /* @Autowired
    private BusinessEventRepository businessEventRepository;

    @Autowired
    private EventPayloadDTOMapper mapDTO;

    public List<EventPayloadDTO> findAll() {
        return businessEventRepository.findAll();
    }

    public Optional<EventPayloadDTO> findById(String idempotenceId) {
        return businessEventRepository.findById(idempotenceId);
    }

    public EventPayloadDTO save(EventPayload eventPayload) throws JsonProcessingException {
        EventPayloadDTO eventPayloadDTO = mapDTO.toEventPayloadDTO(eventPayload);
        return businessEventRepository.save(eventPayloadDTO);
    }

    public void deleteById(String idempotenceId) {
        businessEventRepository.deleteById(idempotenceId);
    }*/

}
