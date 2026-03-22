package com.project.self_todo.com.project.self_todo.com.project.self_todo.controllers;

import com.project.self_todo.com.project.self_todo.com.project.self_todo.services.TaskServicesImplementation;
import com.project.self_todo.com.project.self_todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskServicesImplementation taskService;

    @PostMapping("/api/public/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<> (taskService.createTask(task), HttpStatus.OK);
    }

    @GetMapping("/api/public/task")
    public ResponseEntity<List<Task>> getAllTaskController(){
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/task/{taskId}")
    public ResponseEntity<String> deleteTaskController(@PathVariable Long taskId){
        return new ResponseEntity<>(taskService.deleteTask(taskId),HttpStatus.OK);
    }

    @PutMapping("/api/admin/task/{taskId}")
    public ResponseEntity<String> updateTaskController(@PathVariable Long taskId,@RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(taskId,task),HttpStatus.OK);
    }

    @GetMapping("/api/public/task/{taskId}")
    public ResponseEntity<Task> getTaskByIdController(@PathVariable Long taskId){
        return new ResponseEntity<>(taskService.getTaskById(taskId),HttpStatus.OK);
    }

    @PatchMapping("/api/admin/task/{taskId}/status")
    public ResponseEntity<String> updateTaskStatusController(@PathVariable Long taskId){
        return new ResponseEntity<>(taskService.updateStatus(taskId),HttpStatus.OK);
    }
}
