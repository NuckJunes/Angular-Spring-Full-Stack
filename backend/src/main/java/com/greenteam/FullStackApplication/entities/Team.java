package com.greenteam.FullStackApplication.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Company company;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    private Set<User> teammates=new HashSet<>();

    @OneToMany(mappedBy = "team")
    @EqualsAndHashCode.Exclude
    private Set<Project> projects=new HashSet<>();
}
