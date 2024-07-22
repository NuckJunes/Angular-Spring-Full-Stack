package com.greenteam.FullStackApplication.controllers;

import com.greenteam.FullStackApplication.dtos.CredentialDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.services.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public FullUserDto login(@RequestBody CredentialDto credentialDTO){
        return userService.login(credentialDTO);
    }

}
