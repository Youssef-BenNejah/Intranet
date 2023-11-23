package com.example.intranet.controllers.ManagerManagementController;

import com.example.intranet.Dto.TaskDTO;
import com.example.intranet.Dto.UserDto;
import com.example.intranet.Exceptions.UserNotFoundException;
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
    @PostMapping("{id}/{task_id}")
    public ResponseEntity<?> addEmployeToTask(@PathVariable long id, @PathVariable long task_id
            ){
        UserDto userDto = userService.GetUserById(id);
        if (userDto.getRole()!= Role.EMPLOYE){
            throw new UserNotFoundException("wrong user");
        }
        taskService.addEmployeToTask(id,task_id);
        return ResponseEntity.ok("added succefully");
    }

}
