package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.ProjectDto;
import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.Project;
import com.greenteam.FullStackApplication.entities.Team;
import com.greenteam.FullStackApplication.exceptions.BadRequestException;
import com.greenteam.FullStackApplication.mappers.ProjectMapper;
import com.greenteam.FullStackApplication.mappers.TeamMapper;
import com.greenteam.FullStackApplication.repositories.ProjectRepository;
import com.greenteam.FullStackApplication.services.ProjectService;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ValidateService validateService;
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;
    private final TeamMapper teamMapper;
    @Override
    public ProjectDto postProject(Long companyId, Long teamId, ProjectDto projectDto) {
        Company company=validateService.findCompany(companyId);
        Team team=validateService.findTeam(teamId);
        if(!company.getTeams().contains(team))throw new BadRequestException("Could not find team with id"+teamId);
        Project project=projectMapper.dtoToEntity(projectDto);
        project.setDate(Timestamp.from(Instant.now()));
        return projectMapper.entityToDto(projectRepository.saveAndFlush(project));
    }

    @Override
    public ProjectDto updateProject(Long companyId, Long teamId, Long projectId, ProjectDto projectDto) {
        validateService.findCompany(companyId);
        validateService.findTeam(teamId);
        Project project=validateService.findProject(projectId);
        if(projectDto.getName()!=null){
            project.setName(projectDto.getName());
        }
        if(projectDto.getDescription()!=null){
            project.setDescription(projectDto.getDescription());
        }
        project.setActive(projectDto.isActive());
        if(projectDto.getTeam()!=null){
            project.setTeam(teamMapper.dtoToEntity(projectDto.getTeam()));
        }
        project.setDate(Timestamp.from(Instant.now()));
        return projectMapper.entityToDto(projectRepository.saveAndFlush(project));
    }
}
