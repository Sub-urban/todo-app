package com.project.self_todo.com.project.self_todo.repository;

import com.project.self_todo.com.project.self_todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
