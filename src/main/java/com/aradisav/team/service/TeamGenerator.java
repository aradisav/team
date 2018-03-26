package com.aradisav.team.service;

import com.aradisav.team.domain.Player;
import com.aradisav.team.domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamGenerator {

    public List<Team> generateBiasedTeams(List<Player> players, int teamSize, int numberOfTeams){

        if (numberOfTeams*teamSize>players.size()){
            throw new IllegalArgumentException();
        }

        //sort players by skill index.
        players.sort(Comparator.comparing(Player::getSkillIndex));

        //create team objects
        List<Team> teams = new ArrayList();
        for(int i = 0; i<numberOfTeams; i++ ) {
            teams.add(new Team());
        }


        //distribute players across teams
        int iterationShift = 0;
        for (int i=0; i<players.size(); i++) {

            teams.get((i+iterationShift)%teamSize).getPlayers().add(players.get(i));

            //every 'teamSize' iteration, shift teams by one so that next team gets best available player.
            if (i%teamSize==0) {
                iterationShift++;
            }
        }

        return teams;

    }



}
