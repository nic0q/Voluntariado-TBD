package com.tbd.lab3.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Region;
/**
 * Interface para RegionRepository
 */
public interface RegionRepository extends MongoRepository<Region, ObjectId>{
}
