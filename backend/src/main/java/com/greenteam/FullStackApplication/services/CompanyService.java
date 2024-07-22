package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.TeamDto;
import com.greenteam.FullStackApplication.dtos.AnnouncementDto;
import com.greenteam.FullStackApplication.dtos.FullUserDto;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CompanyService {
    Set<FullUserDto> getAllUsers(Long id);
    Set<TeamDto> getAllTeams(Long id);
    Set<AnnouncementDto> getAnnouncements(Long id);

}
