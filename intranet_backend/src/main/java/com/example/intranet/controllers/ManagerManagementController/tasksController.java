package com.example.intranet.controllers.ManagerManagementController;

import com.example.intranet.Dto.TaskDTO;
import com.example.intranet.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class tasksController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody TaskDTO taskDTO){
        taskService.addTask(taskDTO);
        return ResponseEntity.ok("task added successfully");
    }

}
