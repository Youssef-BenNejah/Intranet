package com.example.intranet.Services;

import com.example.intranet.Dto.UserDto;
import com.example.intranet.entities.UserEntity.Role;
import com.example.intranet.entities.UserEntity.Users;
import com.example.intranet.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public class DefaultUser implements CommandLineRunner {
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        initializeDefaultAdmin();
    }

    private void initializeDefaultAdmin() {

        if (userRepository.existsByEmail("admin@gmail.com")) {
            return;
        }

        // Create a new admin user
        Users admin = new Users();
        admin.setFirstName("Admin");
        admin.setLastName("User");
        admin.setEmail("admin@gmail.com");
        admin.setPassWord(passwordEncoder.encode("admin"));
        admin.setRole(Role.ADMIN);
        admin.setPhoneNumber("90342729");
        admin.setAdresse("admin");

        userRepository.save(admin);

    }
}

