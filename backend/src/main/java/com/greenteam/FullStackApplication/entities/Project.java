package com.greenteam.FullStackApplication.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private boolean active=true;

    @ManyToOne
    private Team team;

    private Timestamp date;
}
