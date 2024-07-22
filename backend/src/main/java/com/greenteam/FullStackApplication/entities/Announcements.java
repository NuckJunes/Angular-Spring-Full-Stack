package com.greenteam.FullStackApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Announcements {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private Timestamp date=Timestamp.valueOf(LocalDateTime.now());

    private String title;

    private String message;

    private boolean deleted;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User author;
}