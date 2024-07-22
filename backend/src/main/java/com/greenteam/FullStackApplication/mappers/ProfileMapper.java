package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.ProfileDto;
import com.greenteam.FullStackApplication.entities.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileMapper INSTANCE= Mappers.getMapper(ProfileMapper.class);
    Profile dtoToEntity(ProfileDto profileDTO);

    ProfileDto entityToDTO(Profile profile);
}
