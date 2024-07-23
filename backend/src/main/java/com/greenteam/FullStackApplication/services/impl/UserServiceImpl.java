package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.BasicUserDto;
import com.greenteam.FullStackApplication.dtos.CredentialDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.dtos.UserRequestDto;
import com.greenteam.FullStackApplication.entities.Company;
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

    @Override
    public FullUserDto createUser(Long id, UserRequestDto userRequestDto) {
        Company company=validateService.findCompany(id);
        if (userRequestDto.getCredentials()==null||userRequestDto.getProfile()==null||
                userRequestDto.getCredentials().getUsername().isEmpty()||
                userRequestDto.getCredentials().getPassword().isEmpty() ||
                userRequestDto.getProfile().getFirstName().isEmpty() ||
                userRequestDto.getProfile().getLastName().isEmpty() ||
                userRequestDto.getProfile().getEmail().isEmpty()){
            throw new BadRequestException("missing profile or credentials or both");
        }
        User user=fullUserMapper.requestDtoToEntity(userRequestDto);
        user.setActive(true);
        user.getCompanies().add(company);
        try {
            return fullUserMapper.entityToFullUserDto(userRepository.saveAndFlush(user));
        }catch (RuntimeException e){
            throw new BadRequestException("A user with that username already exists.Please try again");
        }
    }

    @Override
    public BasicUserDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user=validateService.findUser(id);
        if(userRequestDto.getCredentials()!=null){
            if (userRequestDto.getCredentials().getPassword()!=null){
                user.getCredentials().setPassword(userRequestDto.getCredentials().getPassword());
                user.setStatus("JOINED");
            }
            if (userRequestDto.getCredentials().getUsername()!=null){
                user.getCredentials().setUsername(userRequestDto.getCredentials().getUsername());
            }
            if (userRequestDto.getProfile()!=null){
                if(userRequestDto.getProfile().getEmail()!=null){
                    user.getProfile().setEmail(userRequestDto.getProfile().getEmail());
                }
                if (userRequestDto.getProfile().getPhoneNumber()!=null){
                    user.getProfile().setPhone(userRequestDto.getProfile().getPhoneNumber());
                }
                if(userRequestDto.getProfile().getFirstName()!=null){
                    user.getProfile().setFirstName(userRequestDto.getProfile().getFirstName());
                }
                if(userRequestDto.getProfile().getLastName()!=null){
                    user.getProfile().setLastName(userRequestDto.getProfile().getFirstName());
                }
            }

        }
        userRepository.saveAndFlush(user);
        return basicUserMapper.entityToBasicUserDto(user);
    }
}
