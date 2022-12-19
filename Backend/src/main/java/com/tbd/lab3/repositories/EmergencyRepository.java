package com.tbd.lab3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Emergency;

/**
 * Interface para EmergencyRepository
 */
public interface EmergencyRepository extends MongoRepository<Emergency, Integer> {
}
