package com.example.intranet.repositories;

import com.example.intranet.entities.ProjectEntity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByProjectId(long id);
}
