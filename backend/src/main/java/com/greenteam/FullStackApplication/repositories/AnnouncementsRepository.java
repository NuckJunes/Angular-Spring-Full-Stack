package com.greenteam.FullStackApplication.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementsRepository {
    Optional<AnnouncementsRepository> findById(Long id);
}
