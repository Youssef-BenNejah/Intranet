package com.example.intranet.entities.ProjectEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date date_Begin;

    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date date_end;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    List<Task> tasks = new ArrayList<>();
    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    List<Task> Meeting = new ArrayList<>();

}
