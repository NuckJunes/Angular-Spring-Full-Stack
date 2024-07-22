package com.greenteam.FullStackApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Credential {
    @Column(unique = true,nullable = false)
    private String username;

    private String password;
}