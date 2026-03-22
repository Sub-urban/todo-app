package com.project.self_todo.com.project.self_todo.com.project.self_todo.services;

import com.project.self_todo.com.project.self_todo.model.Task;
import com.project.self_todo.com.project.self_todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServicesImplementation implements TaskServices{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public String deleteTask(Long taskId) {
        Optional<Task> taskOptional =taskRepository.findById(taskId);
        if(taskOptional.isPresent()) {
            taskRepository.deleteById(taskId);
            return "Task with task Id :" + taskId + " have been deleted";
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not found");
        }
    }

    @Override
    public String updateTask(Long taskId, Task task) {
        Task taskFound=taskRepository.findById(taskId)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Task not found with task id "+taskId));
        taskFound.setTaskName(task.getTaskName());
        taskFound.setTaskStatus(task.getTaskStatus());
        taskFound.setTaskDeadLineDate(task.getTaskDeadLineDate());
        taskRepository.save(taskFound);
        return "task updated successfully";
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId){
        return taskRepository.findById(taskId)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Task Id "+taskId+" not found"));

    }

    @Override
    public String updateStatus(Long taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"Task Id "+taskId+" not found"));
        task.setTaskStatus(!task.getTaskStatus());
        taskRepository.save(task);
        return "Status updated";
    }
}
