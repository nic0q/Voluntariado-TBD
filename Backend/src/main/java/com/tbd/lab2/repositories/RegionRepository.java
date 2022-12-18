package com.tbd.lab2.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface para RegionRepository
 */
public interface RegionRepository extends MongoRepository<com.tbd.lab2.Models.Region, ObjectId>{
}
