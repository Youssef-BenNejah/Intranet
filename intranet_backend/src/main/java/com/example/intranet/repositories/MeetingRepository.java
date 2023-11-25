package com.example.intranet.repositories;
import com.example.intranet.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Long> {
}
