package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.exceptions.NotFoundException;
import com.greenteam.FullStackApplication.repositories.UserRepository;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
    private final UserRepository userRepository;
    @Override
    public User findUser(String username) {
        Optional<User> user=userRepository.findByCredentialsUsernameAndActiveTrue(username);
        if(user.isEmpty()){
            throw new NotFoundException("There doesn't appear to be a user with that username");
        }
        return user.get();
    }
}
