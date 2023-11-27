package com.example.intranet.controllers.ManagerManagementController;

import com.example.intranet.Dto.ProjectDTO;
import com.example.intranet.Dto.TaskDTO;
import com.example.intranet.Services.ProjectService;
import com.example.intranet.Services.TaskService;
import com.example.intranet.controllers.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")

public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<ErrorResponse> addProject(@Valid @RequestBody ProjectDTO projectDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            ErrorResponse errorResponse = new ErrorResponse("validation error",errors);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        projectService.addProject(projectDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable long id){
        ProjectDTO projectDTO = projectService.getProject(id);
        return ResponseEntity.ok(projectDTO);
    }
    @GetMapping
    public  ResponseEntity<List<ProjectDTO>> getAllProject(){
        List<ProjectDTO> projectDTOS = projectService.getAllProject();
        if (projectDTOS.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectDTOS);
    }
    @PutMapping("{id}")
    public  ResponseEntity<ErrorResponse> updateProject( ProjectDTO projectDTO,@PathVariable long id,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            ErrorResponse errorResponse = new ErrorResponse("validation error",errors);
            return ResponseEntity.badRequest().body(errorResponse);
        }
        projectService.updateProject(projectDTO,id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable long id){
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
