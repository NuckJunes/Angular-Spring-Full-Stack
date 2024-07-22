package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.FullUserDto;

import java.util.Set;

public interface CompanyService {
    Set<FullUserDto> getAllUsers(Long id);
}
