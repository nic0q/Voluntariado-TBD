package com.tbd.lab3.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Voluntary;
/**
 * Interface para VoluntaryRepository
 */
public interface VoluntaryRepository extends MongoRepository<Voluntary, ObjectId>{
}