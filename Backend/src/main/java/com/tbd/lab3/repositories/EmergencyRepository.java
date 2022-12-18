package com.tbd.lab3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Emergency;

public interface EmergencyRepository extends MongoRepository<Emergency, Integer> {
}
