package com.example.postgredb.relation;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private String playerName;
    private double averageScore;
    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;



}
