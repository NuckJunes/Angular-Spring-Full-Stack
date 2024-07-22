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


}