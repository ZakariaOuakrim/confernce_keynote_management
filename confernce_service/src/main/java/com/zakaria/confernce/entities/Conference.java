package com.zakaria.confernce.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private conferenceType CONFERENCE_TYPE;
    private Date date;
    private double duration;
    private int nbrRegistration;
    private double score;
    private long keyNoteId; //keynote

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
