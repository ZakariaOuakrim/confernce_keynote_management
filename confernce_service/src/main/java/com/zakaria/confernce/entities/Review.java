package com.zakaria.confernce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String text;
    private int score;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;
}
