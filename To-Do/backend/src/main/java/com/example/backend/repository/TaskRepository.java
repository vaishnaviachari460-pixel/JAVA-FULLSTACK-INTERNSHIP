package com.example.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}