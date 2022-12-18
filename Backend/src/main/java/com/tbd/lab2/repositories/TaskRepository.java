package com.tbd.lab2.repositories;

import com.tbd.lab2.Models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, Integer> {
}
