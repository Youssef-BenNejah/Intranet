package com.example.intranet.Dto;

import com.example.intranet.entities.ProjectEntity.Priority;
import com.example.intranet.entities.ProjectEntity.Project;
import com.example.intranet.entities.ProjectEntity.Statuts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TaskDTO {

    private long id;
    @NotBlank(message = "name must be provided")
    private String name;
    @NotBlank(message = "date begin must be provided")
    private Date date_Begin;
    @NotBlank(message = "date end must be provided")
    private Date date_end;

    private Statuts statuts;

    private Priority priority;

    private Project project;
}
