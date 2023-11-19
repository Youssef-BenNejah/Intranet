package com.example.intranet.Services;

import com.example.intranet.Dto.ProjectDTO;
import com.example.intranet.Dto.TaskDTO;
import com.example.intranet.entities.ProjectEntity.Project;
import com.example.intranet.entities.ProjectEntity.Task;
import com.example.intranet.repositories.ProjectRepository;
import com.example.intranet.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

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

}
