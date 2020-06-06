package com.amazon.khatawebservie.repository;

import com.amazon.khatawebservie.mapp.EventPayloadDTOMapper;
import com.amazon.khatawebservie.model.EventPayload;
import com.amazon.khatawebservie.model.EventPayloadDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * implementing methods of DAO
 */
@Service
public class J2BasedEventPayloadDAOImpl implements EventPayloadDAO {

    /**
     * Jpa Repository to perform crud operation
     */
    private BusinessEventRepository businessEventRepository;

    /**
     * mapper for event payload and DTO
     */
    private EventPayloadDTOMapper eventPayloadDTOMapper;

    public J2BasedEventPayloadDAOImpl(BusinessEventRepository businessEventRepository, EventPayloadDTOMapper eventPayloadDTOMapper) {
        this.businessEventRepository = businessEventRepository;
        this.eventPayloadDTOMapper = eventPayloadDTOMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EventPayload> findAll() {
        final List<EventPayloadDTO> eventPayloadDTOS = businessEventRepository.findAll();
        return eventPayloadDTOMapper.toListEventPayload(eventPayloadDTOS);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public EventPayloadDTO save(@NonNull EventPayload eventPayload) {
        final EventPayloadDTO eventPayloadDTO = eventPayloadDTOMapper.toEventPayloadDTO(eventPayload);
        return businessEventRepository.save(eventPayloadDTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EventPayload findById(@NonNull String idempotenceId) {
        final Optional<EventPayloadDTO> OptEventPayloadDTO = businessEventRepository.findById(idempotenceId);
        final EventPayloadDTO eventPayloadDTO =OptEventPayloadDTO.get();
        return eventPayloadDTOMapper.toEventPayload(eventPayloadDTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(String idempotenceId) {
        businessEventRepository.deleteById(idempotenceId);
    }
}
