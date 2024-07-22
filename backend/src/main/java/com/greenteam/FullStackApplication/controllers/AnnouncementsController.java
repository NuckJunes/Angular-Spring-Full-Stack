package com.greenteam.FullStackApplication.controllers;

import com.greenteam.FullStackApplication.entities.Announcements;
import com.greenteam.FullStackApplication.services.AnnouncementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")
public class AnnouncementsController {
    private final AnnouncementsService announcementsService;
}
