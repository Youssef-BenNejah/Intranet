package com.example.intranet.repositories;

import com.example.intranet.entities.UserEntity.Etat;
import com.example.intranet.entities.UserEntity.Role;
import com.example.intranet.entities.UserEntity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {
   Users findUsersByEmail(String email);
   Boolean existsByEmail(String adress);
   Users findUsersByRoleAndId(Role role , long id);

   List<Users> getAllByEtat(Etat etat);

}
