package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.BasicUserDto;
import com.greenteam.FullStackApplication.dtos.CredentialDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.dtos.UserRequestDto;

public interface UserService {
    FullUserDto login(CredentialDto credentialDTO);

    FullUserDto createUser(Long id, UserRequestDto userRequestDto);

    BasicUserDto updateUser(Long id, UserRequestDto userRequestDto);
}
