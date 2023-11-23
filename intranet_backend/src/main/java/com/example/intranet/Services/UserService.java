package com.example.intranet.Services;

import com.example.intranet.Dto.UserDto;
import com.example.intranet.Exceptions.EmailExistException;
import com.example.intranet.config.JwtService;
import com.example.intranet.controllers.AuthenticationController.AuthenticationResponse;
import com.example.intranet.entities.UserEntity.Etat;
import com.example.intranet.entities.UserEntity.Users;
import com.example.intranet.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(UserDto userDto) {
        if (usersRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailExistException("email is exist");
        }
        var user = Users.builder()
                .adresse(userDto.getAdresse()).firstName(userDto.getFirstName()).role(userDto.getRole()).phoneNumber(userDto.getPhoneNumber()).email(userDto.getEmail()).lastName(userDto.getLastName()).passWord(passwordEncoder.encode(userDto.getPassWord())).adresse(userDto.getAdresse()).build();
        usersRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse.builder().token(jwtToken).build();


    }

    public List<UserDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (Users users1 : users) {
            var user = UserDto.builder()
                    .adresse(users1.getAdresse()).
                    phoneNumber(users1.getPhoneNumber()).
                    role(users1.getRole()).passWord(users1.getPassword()).email(users1.getEmail()).firstName(users1.getFirstName()).lastName(users1.getLastName()).id(users1.getId()).build();
            userDtos.add(user);
        }
        return userDtos;
    }
@GetMapping("/getUser/{id}")
    public UserDto GetUserById(long id) {
        Users users = usersRepository.getById(id);
        var user = UserDto.builder().adresse(users.getAdresse()).phoneNumber(users.getPhoneNumber()).role(users.getRole()).passWord(users.getPassword()).email(users.getEmail()).firstName(users.getFirstName()).lastName(users.getLastName()).id(users.getId()).build();
        return user;
    }
@Transactional
    public void updateUser(long id, UserDto userDto) {
        Users existentUser = usersRepository.getById(id);
        existentUser.setEmail(userDto.getEmail());
        existentUser.setAdresse(userDto.getAdresse());
        existentUser.setRole(userDto.getRole());
        existentUser.setLastName(userDto.getLastName());
        existentUser.setPassWord(passwordEncoder.encode(userDto.getPassWord()));
        existentUser.setPhoneNumber(userDto.getPhoneNumber());
        existentUser.setFirstName(userDto.getFirstName());
        usersRepository.save(existentUser);
        var jwt = jwtService.generateToken(existentUser);
        AuthenticationResponse.builder()
                .token(jwt)
                .build();



    }

    public List<Users> getAllByStatus(){
        return usersRepository.getAllByEtat(Etat.ONLINE);
    }


    public void deleteClient(long id) {
        usersRepository.deleteById(id);
    }

    public Boolean existById(long id) {
        return usersRepository.existsById(id);
    }
}
