package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.CredentialDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.entities.Credential;
import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.exceptions.BadRequestException;
import com.greenteam.FullStackApplication.exceptions.NotAuthorizedException;
import com.greenteam.FullStackApplication.mappers.BasicUserMapper;
import com.greenteam.FullStackApplication.mappers.CredentialMapper;
import com.greenteam.FullStackApplication.mappers.FullUserMapper;
import com.greenteam.FullStackApplication.repositories.UserRepository;
import com.greenteam.FullStackApplication.services.UserService;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    /*Services*/
    private final ValidateService validateService;

    /* Mappers */
    private final BasicUserMapper basicUserMapper;
    private final FullUserMapper fullUserMapper;
    private final CredentialMapper credentialMapper;

    /* Repositories */
    private final UserRepository userRepository;

    @Override
    public FullUserDto login(CredentialDto credentialDTO) {
        if(credentialDTO==null||credentialDTO.getUsername()==null||credentialDTO.getPassword()==null){
            throw new BadRequestException("A username and password are needed");
        }
        Credential credentialsToValidate=credentialMapper.dtoToEntity(credentialDTO);
        User userToValidate=validateService.findUser(credentialDTO.getUsername());
        if(!userToValidate.getCredentials().equals(credentialsToValidate)){
            throw new NotAuthorizedException("The username/password is incorrect");
        }
        userRepository.saveAndFlush(userToValidate);
        return fullUserMapper.entityToFullUserDto(userToValidate);
    }
}
