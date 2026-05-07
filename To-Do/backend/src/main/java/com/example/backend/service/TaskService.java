package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Task;
import com.example.backend.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // Add Task
    public Task addTask(Task task) {
        return repository.save(task);
    }

    // Get All Tasks
    public List<Task> getTasks() {
        return repository.findAll();
    }

    // Delete Task
    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}