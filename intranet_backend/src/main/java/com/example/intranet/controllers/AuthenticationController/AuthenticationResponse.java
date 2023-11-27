package com.example.intranet.controllers.AuthenticationController;

import com.example.intranet.entities.UserEntity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private long id;


    private String firstName;


    private String lastName;


    private String email;


    private String passWord;

    private String adresse;

    private String phoneNumber;

    private Role role;


}
