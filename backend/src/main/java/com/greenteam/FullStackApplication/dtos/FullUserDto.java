package com.greenteam.FullStackApplication.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class FullUserDto {
    private Long id;

    private ProfileDto profile;

    private boolean admin;

    private boolean active;

    private String status;

    private Set<CompanyDto> companies;

    private Set<TeamDto> teams;

    public Set<CompanyDto> getCompanies(){
        return this.companies;
    }
}
