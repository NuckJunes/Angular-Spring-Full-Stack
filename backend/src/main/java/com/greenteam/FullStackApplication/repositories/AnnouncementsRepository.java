package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementsRepository extends JpaRepository<Announcements,Long> {
    Optional<Announcements> findByIdAndDeletedFalse(Long id);
}
