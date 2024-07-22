package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Credential;
import com.greenteam.FullStackApplication.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findByCredentials(Credential credential);
    Optional<User> findByCredentialsUsername(String username);
}
