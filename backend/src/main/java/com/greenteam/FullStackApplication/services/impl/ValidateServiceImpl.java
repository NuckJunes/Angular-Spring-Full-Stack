package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.Team;
import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.exceptions.NotFoundException;
import com.greenteam.FullStackApplication.repositories.CompanyRepository;
import com.greenteam.FullStackApplication.repositories.TeamRepository;
import com.greenteam.FullStackApplication.repositories.UserRepository;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final TeamRepository teamRepository;
    @Override
    public User findUser(String username) {
        Optional<User> user=userRepository.findByCredentialsUsernameAndActiveTrue(username);
        if(user.isEmpty()){
            throw new NotFoundException("There doesn't appear to be a user with that username");
        }
        return user.get();
    }

    @Override
    public Company findCompany(Long id) {
        Optional<Company> company= companyRepository.findById(id);
        if(company.isEmpty()){
            throw new NotFoundException("There doesnt appear to be a company with that id");
        }
        return company.get();
    }

    @Override
    public Team findTeam(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isEmpty()) {
            throw new NotFoundException("No team with id " + id);
        }
        return team.get();
    }


}
