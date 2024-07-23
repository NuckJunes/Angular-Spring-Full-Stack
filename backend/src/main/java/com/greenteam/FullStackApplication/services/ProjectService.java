package com.greenteam.FullStackApplication.services;

import com.greenteam.FullStackApplication.dtos.ProjectDto;

public interface ProjectService {
    ProjectDto postProject(Long companyId, Long teamId, ProjectDto projectDto);

    ProjectDto updateProject(Long companyId, Long teamId, Long projectId, ProjectDto projectDto);
}
