package com.example.intranet.entities.ProjectEntity;
import com.example.intranet.entities.UserEntity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date date_Begin;

    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date date_end;

    @Enumerated(EnumType.STRING)
    private Statuts statuts;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    List<Users> users = new ArrayList<>();

}
