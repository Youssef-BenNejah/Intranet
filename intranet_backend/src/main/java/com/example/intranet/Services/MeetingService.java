package com.example.intranet.Services;

import com.example.intranet.Dto.MeetingDTO;
import com.example.intranet.entities.Meeting;
import com.example.intranet.repositories.MeetingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    public void addMeesting(MeetingDTO meetingDTO){
        var meeting = Meeting.builder()
                .date(meetingDTO.getDate())
                .description(meetingDTO.getDescription())
                .project(meetingDTO.getProject()).build();
        meetingRepository.save(meeting);


    }
}
