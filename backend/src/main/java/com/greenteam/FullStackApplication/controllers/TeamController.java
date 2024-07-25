package com.greenteam.FullStackApplication.controllers;

import com.greenteam.FullStackApplication.dtos.BasicUserDto;
import com.greenteam.FullStackApplication.dtos.ProjectDto;
import com.greenteam.FullStackApplication.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{id}/users")
    public Set<BasicUserDto> getTeamMembers(@PathVariable Long id) {
        return teamService.getTeamMembers(id);
    }



}
