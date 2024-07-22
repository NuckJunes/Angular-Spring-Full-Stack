package com.greenteam.FullStackApplication.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @Column(nullable = false)
    private Credential credentials;

    @Embedded
    @Column(nullable = false)
    private Profile profile;

    private boolean active=true;
    private boolean admin=false;

    private String status="PENDING";

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Announcements> announcements=new HashSet<Announcements>() ;




    @ManyToMany
    @JoinTable(name = "company_employees", joinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id",referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    private Set<Company> companies=new HashSet<>();

    @ManyToMany(mappedBy = "teammates" )
    @EqualsAndHashCode.Exclude
    private Set<Team> teams=new HashSet<>();


}