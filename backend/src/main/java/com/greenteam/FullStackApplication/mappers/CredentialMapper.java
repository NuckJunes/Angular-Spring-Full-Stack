package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.CredentialDto;
import com.greenteam.FullStackApplication.entities.Credential;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CredentialMapper {
    CredentialMapper INSTANCE= Mappers.getMapper(CredentialMapper.class);
    Credential dtoToEntity(CredentialDto credentialDto);
}
