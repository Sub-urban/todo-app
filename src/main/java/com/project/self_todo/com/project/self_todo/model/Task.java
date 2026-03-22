package com.project.self_todo.com.project.self_todo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;

    private Boolean taskStatus;

    private LocalDate taskDeadLineDate;

    public Task()
    {

    }
    @Transient
    public boolean isOverdue(){
        if(taskStatus ==true || taskDeadLineDate == null){
            return false;
        }
        else
            return taskDeadLineDate.isBefore(LocalDate.now());
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDeadLineDate(LocalDate taskDeadLineDate) {
        this.taskDeadLineDate = taskDeadLineDate;
    }

    public void setTaskStatus(Boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getTaskId() {
        return taskId;
    }
    public String getTaskName(){
        return taskName;
    }

    public Boolean getTaskStatus() {
        return taskStatus;
    }

    public LocalDate getTaskDeadLineDate() {
        return taskDeadLineDate;
    }

}
