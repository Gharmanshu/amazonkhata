package com.amazon.khatawebservie.repository;

import com.amazon.khatawebservie.model.EventPayloadDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository used is JpaRepository
 * It will have methods to create, read, update and delete model
 * model passed is BusinessEvent with Long type primary key
 *All the methods can be seen in service class
 */
public interface BusinessEventRepository extends JpaRepository<EventPayloadDTO, String> {

}