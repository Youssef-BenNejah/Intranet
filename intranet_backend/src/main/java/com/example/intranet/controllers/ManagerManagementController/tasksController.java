package com.example.intranet.controllers.ManagerManagementController;

import com.example.intranet.Dto.TaskDTO;
import com.example.intranet.Dto.UserDto;
import com.example.intranet.Services.TaskService;
import com.example.intranet.Services.UserService;
import com.example.intranet.entities.UserEntity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class tasksController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody TaskDTO taskDTO){
        taskService.addTask(taskDTO);
        return ResponseEntity.ok("task added successfully");
    }
    @PutMapping("/{id}/{task_id}")
    public ResponseEntity<?> addUserToTask(@PathVariable long id,@PathVariable long task_id)

    {
        UserDto users = userService.GetUserById(id);
        if (users.getRole() == Role.EMPLOYE){
            taskService.addEmployeToTask(id,task_id);
            return ResponseEntity.ok().build();
        }return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/{id}/{task_id}")
    public ResponseEntity<Void> deleteUserFromTask(@PathVariable long id,@PathVariable long task_id)
    {
        taskService.deleteEmployeFromTask(id,task_id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTache(@PathVariable long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO){
        taskService.updateTask(id,taskDTO);
        return ResponseEntity.ok().build();
    }


}
