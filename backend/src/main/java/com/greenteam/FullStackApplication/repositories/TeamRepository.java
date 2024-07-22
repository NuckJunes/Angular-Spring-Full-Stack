package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    // Optional methods
}