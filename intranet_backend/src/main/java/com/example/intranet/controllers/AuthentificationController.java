package com.example.intranet.controllers;

import com.example.intranet.Dto.AuthenticationDTO;
import com.example.intranet.Dto.UserDto;
import com.example.intranet.Services.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authentication")
public class AuthentificationController {
    @Autowired
    private UserServiceImp userService;



    @PostMapping("/Login")

    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationDTO authenticationDTO){
        return ResponseEntity.ok(userService.authenticate(authenticationDTO));

    }


}
