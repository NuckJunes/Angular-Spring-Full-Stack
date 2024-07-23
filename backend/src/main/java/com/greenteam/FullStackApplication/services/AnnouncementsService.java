package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.AnnouncementDto;

public interface AnnouncementsService {
    AnnouncementDto postAnnouncement(Long id, AnnouncementDto announcementDto);
}
