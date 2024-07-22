package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.dtos.UserRequestDto;
import com.greenteam.FullStackApplication.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialMapper.class, CompanyMapper.class, TeamMapper.class})
public interface FullUserMapper {
    FullUserMapper INSTANCE= Mappers.getMapper(FullUserMapper.class);
    FullUserDto entityToFullUserDto(User user);

    Set<FullUserDto> entitiesToFullUserDtos(Set<User> users);

    User requestDtoToEntity(UserRequestDto userRequestDto);
}