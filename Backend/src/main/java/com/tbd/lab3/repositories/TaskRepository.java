package com.tbd.lab3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Task;

public interface TaskRepository extends MongoRepository<Task, Integer> {
}
