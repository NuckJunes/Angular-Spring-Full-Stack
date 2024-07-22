package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.Team;
import com.greenteam.FullStackApplication.entities.User;

public interface ValidateService {
    User findUser(String username);

    Company findCompany(Long id);

    Team findTeam(Long id);
}
