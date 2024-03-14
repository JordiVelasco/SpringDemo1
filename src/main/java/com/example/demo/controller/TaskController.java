package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskRepositry taskRepositry;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepositry.findAll();
    }

    @PostMapping
    public Task createTask(Task task){
        return taskRepositry.save(task);
    }

    @DeleteMapping
    public void deleTask(Long id){
        taskRepositry.deleteById(id);
    }

    @PutMapping
    public Task updateTask(Long id, Task nameTask){
        Optional auxId = taskRepositry.findById(id);
        if (auxId.isEmpty()){
            throw new RuntimeException("Task not found");
        }else{
            return taskRepositry.save(nameTask);
        }
    }
}
