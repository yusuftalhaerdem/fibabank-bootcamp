package com.example.postgredb.relation;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private String teamName;
    @OneToMany(mappedBy = "team",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Player> playerList;


}
