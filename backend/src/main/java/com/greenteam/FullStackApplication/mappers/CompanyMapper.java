package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.CompanyDto;
import com.greenteam.FullStackApplication.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {TeamMapper.class,BasicUserMapper.class})
public interface CompanyMapper {
    CompanyMapper INSTANCE= Mappers.getMapper(CompanyMapper.class);
    CompanyDto entityToDto(Company company);

    Set<CompanyDto> entitiesToDtos(Set<Company> companies);
}
