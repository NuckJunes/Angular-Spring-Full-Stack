package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.*;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CompanyService {
    Set<FullUserDto> getAllUsers(Long id);
    Set<TeamDto> getAllTeams(Long id);
    Set<AnnouncementDto> getAnnouncements(Long id);
    Set<ProjectDto> getAllProjects(Long id);
    Set<ProjectDto> getTeamProjects(Long cId, Long tId);
    TeamDto setTeam(TeamDto t, Long id);

    Set<CompanyDto> getAllCompanies(CredentialDto credentialDto);
}
