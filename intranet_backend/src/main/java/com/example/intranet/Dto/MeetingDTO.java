package com.example.intranet.Dto;

import com.example.intranet.entities.ProjectEntity.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDTO {

    private long id;
    private String description;

    private Date date;

    private Project project;
}
