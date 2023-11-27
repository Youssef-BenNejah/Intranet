package com.example.intranet.controllers.AuthenticationController;

import com.example.intranet.Dto.AuthenticationDTO;
import com.example.intranet.Services.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")
public class AuthentificationController {
    @Autowired
    private AuthentificationService authentificationService;



    @PostMapping("/Login")

    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationDTO authenticationDTO){
        return ResponseEntity.ok(authentificationService.authenticate(authenticationDTO));

    }


}
