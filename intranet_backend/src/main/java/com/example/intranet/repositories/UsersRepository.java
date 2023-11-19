package com.example.intranet.repositories;

import com.example.intranet.entities.UserEntity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {
   Users findUsersByEmail(String email);
   Boolean existsByEmail(String adress);

}
