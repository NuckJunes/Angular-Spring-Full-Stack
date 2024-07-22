package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Project;
import com.greenteam.FullStackApplication.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    Optional<Project> findById(Long id);
    Optional<Project> findByName(String name);
    Optional<Project> findByTeam(Team team);
}
