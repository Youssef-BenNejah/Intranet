package com.example.intranet.Dto;

import com.example.intranet.entities.ProjectEntity.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProjectDTO {

    private long id;

    @NotNull(message = "name must provided")
    private String name;

    @NotNull(message = "date must be provided")
    private Date date_Begin;

    private Date date_end;


}
