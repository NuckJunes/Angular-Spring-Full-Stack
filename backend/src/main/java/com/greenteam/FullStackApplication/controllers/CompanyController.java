package com.greenteam.FullStackApplication.controllers;

import com.greenteam.FullStackApplication.dtos.CompanyDto;

import com.greenteam.FullStackApplication.dtos.TeamDto;
import com.greenteam.FullStackApplication.dtos.AnnouncementDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.dtos.ProjectDto;
import com.greenteam.FullStackApplication.services.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/{id}/users")
    public Set<FullUserDto> getAllUsers(@PathVariable Long id){
        return companyService.getAllUsers(id);
    }
    
    @GetMapping("/{id}/teams")
    public Set<TeamDto> getAllTeams(@PathVariable Long id){
        return companyService.getAllTeams(id);
    }
    
    @GetMapping("/{id}/announcements")
    public Set<AnnouncementDto> getAnnouncements(@PathVariable Long id){
        return companyService.getAnnouncements(id);
    }
    
    public Set<ProjectDto> getProjects(@PathVariable Long id){
    	return companyService.getAllProjects(id);
    }
    

    
}
