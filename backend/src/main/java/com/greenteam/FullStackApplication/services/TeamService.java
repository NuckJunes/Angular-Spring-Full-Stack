package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.BasicUserDto;

import java.util.List;
import java.util.Set;

public interface TeamService {
    Set<BasicUserDto> getTeamMembers(Long id);
}
