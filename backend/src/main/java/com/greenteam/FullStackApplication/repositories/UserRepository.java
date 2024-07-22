package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Credential;
import com.greenteam.FullStackApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByCredentials(Credential credential);

    Optional<User> findByCredentialsUsernameAndActiveTrue(String username);

    Optional<User> findByIdAndActiveTrue(Long id);

    Optional<User> findByProfileEmailAndActiveTrue(String email);
}