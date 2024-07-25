package com.greenteam.FullStackApplication.controllers;

import com.greenteam.FullStackApplication.dtos.*;

import com.greenteam.FullStackApplication.services.AnnouncementsService;
import com.greenteam.FullStackApplication.services.CompanyService;

import com.greenteam.FullStackApplication.services.ProjectService;
import com.greenteam.FullStackApplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyService companyService;
    private final UserService userService;
    private final AnnouncementsService announcementsService;
    private final ProjectService projectService;

    @GetMapping("/{id}/users")
    public Set<FullUserDto> getAllUsers(@PathVariable Long id){
        return companyService.getAllUsers(id);
    }
    
    @GetMapping("/{id}/teams")
    public Set<TeamDto> getAllTeams(@PathVariable Long id){
        return companyService.getAllTeams(id);
    }
    
    @GetMapping("/{id}/announcements")
    public List<AnnouncementDto> getAnnouncements(@PathVariable Long id){
        return companyService.getAnnouncements(id);
    }
    
    @GetMapping("/{id}/projects")
    public Set<ProjectDto> getProjects(@PathVariable Long id){
    	return companyService.getAllProjects(id);
    }
    
    @GetMapping("/{cId}/teams/{tId}/projects")
    public Set<ProjectDto> getTeamProjects(@PathVariable Long cId, @PathVariable Long tId){
    	return companyService.getTeamProjects(cId, tId);
    }
    
    @PostMapping("/{id}/teams")
    public TeamDto setTeam(@RequestBody TeamDto t, @PathVariable Long id){
    	return companyService.setTeam(t, id);
    }

    @GetMapping("/all")
    public Set<CompanyDto> getAllCompanies(@RequestBody CredentialDto credentialDto){
        return companyService.getAllCompanies(credentialDto);
    }

    @PostMapping("/{id}/user")
    @ResponseStatus(HttpStatus.CREATED)
    public FullUserDto createUser(@PathVariable Long id,@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(id, userRequestDto);
    }
    @PostMapping("/{id}/announcement")
    @ResponseStatus(HttpStatus.CREATED)
    public AnnouncementDto postAnnouncement(@PathVariable Long id,@RequestBody AnnouncementDto announcementDto){
        return announcementsService.postAnnouncement(id, announcementDto);
    }
    @PostMapping("/{companyId}/teams/{teamId}/project")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto postProject(@PathVariable Long companyId,@PathVariable Long teamId,@RequestBody ProjectDto projectDto){
        return projectService.postProject(companyId, teamId, projectDto);
    }
    @PutMapping("/{companyId}/teams/{teamId}/project/{projectId}")
    public ProjectDto updateProject(@PathVariable Long companyId, @PathVariable Long teamId,
                                    @PathVariable Long projectId, @RequestBody ProjectDto projectDto) {
        return projectService.updateProject(companyId, teamId, projectId, projectDto);
    }
}
