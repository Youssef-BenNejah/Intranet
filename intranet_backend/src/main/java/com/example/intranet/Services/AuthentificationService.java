package com.example.intranet.Services;

import com.example.intranet.Dto.AuthenticationDTO;
import com.example.intranet.Exceptions.UserNotFoundException;
import com.example.intranet.config.JwtService;
import com.example.intranet.controllers.AuthenticationController.AuthenticationResponse;
import com.example.intranet.entities.UserEntity.Etat;
import com.example.intranet.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    public AuthenticationResponse authenticate(AuthenticationDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassWord()
                )
        );
        if (request == null){
            throw new UserNotFoundException("user not found");
        }
        var user = usersRepository.findUsersByEmail(request.getEmail());
        user.setEtat(Etat.ONLINE);
        usersRepository.save(user);
        var JwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(JwtToken)
                .build();
    }


}
