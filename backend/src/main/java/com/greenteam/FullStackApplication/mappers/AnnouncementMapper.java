package com.greenteam.FullStackApplication.mappers;

import com.greenteam.FullStackApplication.dtos.AnnouncementDto;
import com.greenteam.FullStackApplication.entities.Announcements;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { BasicUserMapper.class })
public interface AnnouncementMapper {
    AnnouncementMapper INSTANCE= Mappers.getMapper(AnnouncementMapper.class);
    AnnouncementDto entityToDTO(Announcements announcement);

    Set<AnnouncementDto> entitiesToDTOs(Set<Announcements> announcements);

    Announcements dtoToEntity(AnnouncementDto announcementDTO);
}

