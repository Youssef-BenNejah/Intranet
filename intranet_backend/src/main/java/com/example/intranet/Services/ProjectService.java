package com.example.intranet.Services;

import com.example.intranet.Dto.ProjectDTO;
import com.example.intranet.entities.ProjectEntity.Project;
import com.example.intranet.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    public void addProject(ProjectDTO projectDTO){
        var project = Project.builder()
                .id(projectDTO.getId())
                .date_Begin(projectDTO.getDate_Begin())
                .date_end(projectDTO.getDate_end())
                .name(projectDTO.getName())
                .build();
        projectRepository.save(project);


    }

    public ProjectDTO getProject(Long id){
        Project project = projectRepository.getById(id);
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDate_Begin(project.getDate_Begin());
        projectDTO.setDate_end(project.getDate_end());
        return projectDTO;

    }

    public List<ProjectDTO> getAllProject(){
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOS =new ArrayList<>();
        for (Project project : projects){
            var projectDTO = ProjectDTO.builder()
                    .id(project.getId())
                    .name(project.getName())
                    .date_Begin(project.getDate_Begin())
                    .date_end(project.getDate_end())
                    .build();
            projectDTOS.add(projectDTO);
        }
        return projectDTOS;
    }


    public void updateProject(ProjectDTO projectDTO,long id){
        Project project = projectRepository.getById(id);
        project.setName(projectDTO.getName());
        project.setId(projectDTO.getId());
        project.setDate_end(projectDTO.getDate_end());
        project.setDate_Begin(projectDTO.getDate_Begin());
        projectRepository.save(project);

    }

    public void deleteProject(long id){
        projectRepository.deleteById(id);
    }
}
