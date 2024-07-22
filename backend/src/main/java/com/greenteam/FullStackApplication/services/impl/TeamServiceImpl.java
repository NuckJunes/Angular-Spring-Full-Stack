package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.BasicUserDto;
import com.greenteam.FullStackApplication.entities.Team;
import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.mappers.BasicUserMapper;
import com.greenteam.FullStackApplication.repositories.TeamRepository;
import com.greenteam.FullStackApplication.services.TeamService;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ValidateService validateService;

    private final BasicUserMapper basicUserMapper;

    @Override
    public Set<BasicUserDto> getTeamMembers(Long id) {
        Team team = validateService.findTeam(id);
        Set<BasicUserDto> teamMembers = basicUserMapper.entitiesToBasicUserDtos(team.getTeammates());
        Set<BasicUserDto> activeTeamMembers = new HashSet<>(teamMembers);
        activeTeamMembers.removeIf(user -> !user.isActive());
        return activeTeamMembers;
    }
}
