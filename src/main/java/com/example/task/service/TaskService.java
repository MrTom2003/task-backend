package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        task.setCreated(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id).ifPresentOrElse(task -> {
            taskRepository.delete(task);
        }, () -> {
            throw new RuntimeException("sdfsdf");
        });
    }
}
