package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.CredentialDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;

public interface UserService {
    FullUserDto login(CredentialDto credentialDTO);
}
