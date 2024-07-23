package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.*;
import com.greenteam.FullStackApplication.entities.Announcements;
import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.entities.Team;
import com.greenteam.FullStackApplication.entities.Project;
import com.greenteam.FullStackApplication.exceptions.NotFoundException;
import com.greenteam.FullStackApplication.mappers.AnnouncementMapper;
import com.greenteam.FullStackApplication.mappers.FullUserMapper;
import com.greenteam.FullStackApplication.mappers.ProjectMapper; 
import com.greenteam.FullStackApplication.mappers.TeamMapper;
import com.greenteam.FullStackApplication.repositories.TeamRepository;
import com.greenteam.FullStackApplication.services.CompanyService;
import com.greenteam.FullStackApplication.services.UserService;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final FullUserMapper fullUserMapper;
    private final TeamMapper teamMapper;
    private final AnnouncementMapper announceMapper;
    private final ProjectMapper projectMapper;
    private final ValidateService validateService;
    private final UserService userService;
    
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
        List<Announcements> sortedList=new ArrayList<>(company.getAnnouncements());
        sortedList.sort(Comparator.comparing(Announcements::getDate).reversed());
        Set<Announcements> allAnnounces=new HashSet<>(sortedList);
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
    	Company company=validateService.findCompany(cid);
        Team team=validateService.findTeam(tid);
        if (!company.getTeams().contains(team)){
            throw new NotFoundException("A team with id "+tid+"does not exist at company with id"+cid);
        }
        Set<Project> filteredProjects=new HashSet<>();
        team.getProjects().forEach(filteredProjects::add);
        return projectMapper.entitiesToDtos(filteredProjects);
    }
    
    
    @Override
    public TeamDto setTeam(TeamDto t, Long id) {
        Company company=validateService.findCompany(id);
        Team team=teamMapper.dtoToEntity(t);
        team.setCompany(company);
        return teamMapper.entityToDto(teamRepository.saveAndFlush(team));
    }

    @Override
    public Set<CompanyDto> getAllCompanies(CredentialDto credentialDto) {
        FullUserDto fullUserDto=userService.login(credentialDto);
        return fullUserDto.getCompanies();
    }


}

