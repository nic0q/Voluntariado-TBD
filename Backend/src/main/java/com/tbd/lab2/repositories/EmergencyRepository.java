package com.tbd.lab2.repositories;

import com.tbd.lab2.Models.Emergency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmergencyRepository extends MongoRepository<Emergency, Integer> {
}
