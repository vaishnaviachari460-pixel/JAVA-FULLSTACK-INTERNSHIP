package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Task;
import com.example.backend.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService service;

    // Add Task
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    // Get All Tasks
    @GetMapping
    public List<Task> getTasks() {
        return service.getTasks();
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        service.deleteTask(id);
    }
}