package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.TeamDto;
import com.greenteam.FullStackApplication.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {BasicUserMapper.class})
public interface TeamMapper {
    TeamMapper INSTANCE= Mappers.getMapper(TeamMapper.class);
    TeamDto entityToDto(Team team);

    Set<TeamDto> entitiesToDtos(Set<Team> teams);

    Set<Team> dtosToEntities(Set<TeamDto> teamDtos);

    Team dtoToEntity(TeamDto teamDto);
}
