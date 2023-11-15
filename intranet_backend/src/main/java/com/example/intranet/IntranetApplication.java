package com.example.intranet;

import com.example.intranet.Dto.UserDto;
import com.example.intranet.Services.AuthentificationService;
import com.example.intranet.entities.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntranetApplication.class, args);


	}
	@Bean
	CommandLineRunner commandLineRunner(
			AuthentificationService userServiceImp
	){
		return args -> UserDto.builder()
				.adresse("Admin")
				.email("Admin@gmail.com")
				.firstName("Admin")
				.lastName("gg")
				.role(Role.ADMIN)
				.passWord("123456")
				.phoneNumber("123456")
				.build();
	}

}
