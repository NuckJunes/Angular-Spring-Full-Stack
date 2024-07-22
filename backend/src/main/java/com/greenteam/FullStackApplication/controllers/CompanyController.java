package com.greenteam.FullStackApplication.controllers;

import com.greenteam.FullStackApplication.dtos.FullUserDto;
import com.greenteam.FullStackApplication.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/{id}/users")
    public Set<FullUserDto> getAllUsers(@PathVariable Long id){
        return companyService.getAllUsers(id);
    }
}
