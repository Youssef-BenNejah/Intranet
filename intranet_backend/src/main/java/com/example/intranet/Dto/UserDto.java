package com.example.intranet.Dto;

import com.example.intranet.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UserDto {
    private long id;

    @NotBlank(message = "first name must be provided")
    private String firstName;

    @NotBlank(message = "last name must be provided")
    private String lastName;

    @Email
    @NotBlank(message = "email must be provided")
    private String email;

    @NotBlank(message = "password must be provided")
    @Size(min = 6 ,message = "password must be at least 6 character")
    private String passWord;

    private String adresse;

    private String phoneNumber;

    private Role role;



    }

