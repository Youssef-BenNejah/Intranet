package com.example.intranet.controllers;

import com.example.intranet.Dto.MeetingDTO;
import com.example.intranet.Services.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @PostMapping
    public ResponseEntity<?> addMetting(@RequestBody MeetingDTO meetingDTO){
        meetingService.addMeesting(meetingDTO);
        return ResponseEntity.ok().build();
    }
}
