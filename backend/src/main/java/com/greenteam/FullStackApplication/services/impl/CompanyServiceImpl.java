package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.AnnouncementDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.dtos.ProjectDto;
import com.greenteam.FullStackApplication.dtos.TeamDto;
import com.greenteam.FullStackApplication.entities.Announcements;
import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.entities.Team;
import com.greenteam.FullStackApplication.entities.Project;
import com.greenteam.FullStackApplication.mappers.AnnouncementMapper;
import com.greenteam.FullStackApplication.mappers.FullUserMapper;
import com.greenteam.FullStackApplication.mappers.ProjectMapper; 
import com.greenteam.FullStackApplication.mappers.TeamMapper;
import com.greenteam.FullStackApplication.repositories.TeamRepository;
import com.greenteam.FullStackApplication.services.CompanyService;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final FullUserMapper fullUserMapper;
    private final TeamMapper teamMapper;
    private final AnnouncementMapper announceMapper;
    private final ProjectMapper projectMapper;
    private final ValidateService validateService;
    
    private final TeamRepository teamRepository;
    
    @Override
    public Set<FullUserDto> getAllUsers(Long id) {
        Company company=validateService.findCompany(id);
        Set<User> filteredUsers=new HashSet<>();
        company.getEmployees().forEach(filteredUsers::add);
        filteredUsers.removeIf(user -> !user.isActive());
        return fullUserMapper.entitiesToFullUserDtos(filteredUsers);
    }
    
    @Override
    public Set<TeamDto> getAllTeams(Long id) {
        Company company=validateService.findCompany(id);
        Set<Team> allTeams =new HashSet<>();
        company.getTeams().forEach(allTeams::add);
        return teamMapper.entitiesToDtos(allTeams);
    }
    
    @Override
    public Set<AnnouncementDto> getAnnouncements(Long id) {
        Company company=validateService.findCompany(id);
        Set<Announcements> allAnnounces =new HashSet<>();
        company.getAnnouncements().forEach(allAnnounces::add);
        return announceMapper.entitiesToDtos(allAnnounces);
    }
    
    @Override    
    public Set<ProjectDto> getAllProjects(Long id) {
        Company company=validateService.findCompany(id);
    	Set<Team> allTeams = teamRepository.findAllByCompany(company);
    	Set<Project> allProjects = new HashSet<>();
    	
    	for(Team t : allTeams) {
    		for(Project p : t.getProjects()) {
    			allProjects.add(p);
    		}
    	}
    	
    	return projectMapper.entitiesToDtos(allProjects);
    }
    
    @Override
    public Set<ProjectDto> getTeamProjects(Long cid, Long tid) {
    	Team team = validateService.findTeam(tid);
    	Set<Project> allProjects = new HashSet<>();
    	
    		for(Project p : team.getProjects()) {
    			allProjects.add(p);
    		}
    	return projectMapper.entitiesToDtos(allProjects);
    }

    
    
}

