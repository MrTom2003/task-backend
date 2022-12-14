package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.service.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> geTasks() {
        return taskService.getAllTasks();
        //throw new RuntimeException(("Asd"));
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTask(@PathVariable(name= "id") long id) {
        return ResponseEntity.ok().body(taskService.getTask(id));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.saveTask(task));

    }
    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable(value="id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().body(null);
    }

}
