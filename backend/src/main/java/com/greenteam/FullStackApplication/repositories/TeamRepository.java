package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Project;
import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    @Override
    Optional<Team> findById(Long id);
    Set<Team> findAllByCompany(Company company);

}