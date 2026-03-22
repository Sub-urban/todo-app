package com.project.self_todo.com.project.self_todo.com.project.self_todo.services;

import com.project.self_todo.com.project.self_todo.model.Task;

import java.util.List;

public interface TaskServices {
    Task createTask(Task task);
    String deleteTask(Long taskId);
    String updateTask(Long taskId,Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long taskId);
    String updateStatus(Long taskId);
}
