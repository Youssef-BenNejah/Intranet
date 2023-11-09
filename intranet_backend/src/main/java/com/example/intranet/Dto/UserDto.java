package com.example.intranet.Dto;

import com.example.intranet.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private String adresse;
    private String phoneNumber;
    private Role role;

    }

