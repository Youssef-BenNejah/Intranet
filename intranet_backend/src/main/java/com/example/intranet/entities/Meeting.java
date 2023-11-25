package com.example.intranet.entities;

import com.example.intranet.entities.ProjectEntity.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date date;
     @ManyToOne
     @JoinColumn(name = "project_id")
    private Project project;


}
