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
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "company")
    @EqualsAndHashCode.Exclude
    private Set<Announcements> announcements=new HashSet<>();

    @ManyToMany(mappedBy = "companies")
    @EqualsAndHashCode.Exclude
    private Set<User> employees=new HashSet<>();

    
    @OneToMany(mappedBy = "company")
    @EqualsAndHashCode.Exclude
    private Set<Team> teams=new HashSet<>();
}
