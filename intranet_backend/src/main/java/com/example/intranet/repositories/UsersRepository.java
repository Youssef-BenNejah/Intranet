package com.example.intranet.repositories;

import com.example.intranet.Dto.UserDto;
import com.example.intranet.entities.UserEntity.Role;
import com.example.intranet.entities.UserEntity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {
   Users findUsersByEmail(String email);
   Boolean existsByEmail(String adress);
   List<Users> findUsersByRole(Role role);
   Users findUserByRoleAndId(Role role,long id);

}
