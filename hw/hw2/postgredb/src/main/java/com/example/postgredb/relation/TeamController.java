package com.example.postgredb.relation;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("sport")
public class TeamController {

    private TeamRepository teamRepository;

    private TeamController(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }

    @GetMapping("team/insert")
    @ResponseBody
    public String insertTeam(){
        Team team = new Team();
        team.setTeamName("t1");

        Player player = new Player();
        player.setPlayerName("p1");
        player.setAverageScore(151.1);
        player.setTeam(team);

        Player player2 = new Player();
        player2.setPlayerName("p2");
        player2.setAverageScore(251.1);
        player2.setTeam(team);

        team.setPlayerList(new ArrayList<>());
        team.getPlayerList().add(player);
        team.getPlayerList().add(player2);
        teamRepository.save(team);

        return "inserted. team:"+ team.getTeamId();
    }

}
