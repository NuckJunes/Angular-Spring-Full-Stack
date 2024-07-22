package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.BasicUserDto;
import com.greenteam.FullStackApplication.dtos.UserRequestDto;
import com.greenteam.FullStackApplication.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialMapper.class})
public interface BasicUserMapper {
    BasicUserMapper INSTANCE= Mappers.getMapper(BasicUserMapper.class);
    BasicUserDto entityToBasicUserDto(User user);

    Set<BasicUserDto> entitiesToBasicUserDtos(Set<User> users);



    User requestDtoToEntity(UserRequestDto userRequestDto);
}
