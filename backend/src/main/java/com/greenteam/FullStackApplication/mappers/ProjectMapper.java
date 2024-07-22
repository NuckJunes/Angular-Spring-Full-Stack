package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.ProjectDto;
import com.greenteam.FullStackApplication.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring",uses = {TeamMapper.class})
public interface ProjectMapper {
    ProjectMapper INSTANCE= Mappers.getMapper(ProjectMapper.class);
    ProjectDto entityToDto(Project project);

    Set<ProjectDto> entitiesToDtos(Set<Project> projects);

    Project dtoToEntity(ProjectDto projectDto);
}