package com.example.intranet.Services;

import com.example.intranet.Dto.ProjectDTO;
import com.example.intranet.Dto.TaskDTO;
import com.example.intranet.Exceptions.UserNotFoundException;
import com.example.intranet.entities.ProjectEntity.Project;
import com.example.intranet.entities.ProjectEntity.Task;
import com.example.intranet.entities.UserEntity.Role;
import com.example.intranet.entities.UserEntity.Users;
import com.example.intranet.repositories.ProjectRepository;
import com.example.intranet.repositories.TaskRepository;
import com.example.intranet.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UsersRepository usersRepository;



    public void addTask(TaskDTO taskDTO){
        Task task = new Task();
        Project project = new Project();

        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setProject(taskDTO.getProject());
        task.setStatuts(taskDTO.getStatuts());
        task.setDate_Begin(taskDTO.getDate_Begin());
        task.setDate_end(taskDTO.getDate_end());
        task.setPriority(taskDTO.getPriority());
        task.setProject(taskDTO.getProject());
        project.getTasks().add(task);

        taskRepository.save(task);
    }

    public List<TaskDTO> getTasksbyProjectId(long id){
        List<Task> tasks = taskRepository.findAllByProjectId(id);
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks){
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setName(task.getName());
            taskDTO.setPriority(task.getPriority());
            taskDTO.setStatuts(task.getStatuts());
            taskDTO.setPriority(task.getPriority());
            taskDTO.setDate_end(task.getDate_end());
            taskDTO.setDate_Begin(task.getDate_Begin());
            taskDTOS.add(taskDTO);
        }
        return taskDTOS;
    }

    public void updateTask(long id, TaskDTO taskDTO){
        Task task = taskRepository.getById(id);
        task.setDate_end(taskDTO.getDate_end());
        task.setName(task.getName());
        task.setDate_Begin(taskDTO.getDate_Begin());
        task.setStatuts(taskDTO.getStatuts());
        task.setPriority(taskDTO.getPriority());
        taskRepository.save(task);
    }

    public void addEmployeToTask(long id , long task_id){
        Users users = usersRepository.findUserByRoleAndId(Role.EMPLOYE,id);
        Task task = taskRepository.getById(task_id);
        task.setUser(users);
        taskRepository.save(task);

    }
    public void deleteEmployeFromTask(long id , long task_id){
        Users users = usersRepository.findUserByRoleAndId(Role.EMPLOYE,id);
        if (users==null){
            throw new UserNotFoundException("user is not an employe");
        }
        Task task = taskRepository.getById(task_id);
        task.setUser(null);
        taskRepository.save(task);
    }
    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }



}
