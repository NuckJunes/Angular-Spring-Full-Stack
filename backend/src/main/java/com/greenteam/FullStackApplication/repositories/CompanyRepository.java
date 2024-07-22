package com.greenteam.FullStackApplication.repositories;

import com.greenteam.FullStackApplication.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository {
    Optional<Company> findById(Long id);
}
