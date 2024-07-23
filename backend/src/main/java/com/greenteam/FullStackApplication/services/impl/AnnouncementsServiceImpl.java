package com.greenteam.FullStackApplication.services.impl;

import com.greenteam.FullStackApplication.dtos.AnnouncementDto;
import com.greenteam.FullStackApplication.entities.Announcements;
import com.greenteam.FullStackApplication.entities.Company;
import com.greenteam.FullStackApplication.entities.User;
import com.greenteam.FullStackApplication.exceptions.BadRequestException;
import com.greenteam.FullStackApplication.mappers.AnnouncementMapper;
import com.greenteam.FullStackApplication.repositories.AnnouncementsRepository;
import com.greenteam.FullStackApplication.services.AnnouncementsService;
import com.greenteam.FullStackApplication.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnnouncementsServiceImpl implements AnnouncementsService {
    private final ValidateService validateService;
    private final AnnouncementMapper announcementMapper;
    private final AnnouncementsRepository announcementsRepository;
    @Override
    public AnnouncementDto postAnnouncement(Long id, AnnouncementDto announcementDto) {
        Company company = validateService.findCompany(id);
        User user = validateService.findUser(announcementDto.getAuthor().getId());
        if (!announcementDto.getAuthor().isActive()) throw new BadRequestException("This user is not currently active");
        Announcements announcement = announcementMapper.dtoToEntity(announcementDto);
        announcement.setDate(Timestamp.valueOf(LocalDateTime.now()));
        announcement.setCompany(company);
        announcement.getAuthor().setProfile(user.getProfile());
        Announcements savedAnnouncement=announcementsRepository.save(announcement);
        return announcementMapper.entityToDto(savedAnnouncement);
    }
}
