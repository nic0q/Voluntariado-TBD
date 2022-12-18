package com.tbd.lab2.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface para VoluntaryRepository
 */
public interface VoluntaryRepository extends MongoRepository<com.tbd.lab2.Models.Voluntary, ObjectId>{
}