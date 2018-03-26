package com.aradisav.team.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aradisav.team.domain.Player;
import com.aradisav.team.domain.Team;

@Service
public class TeamGenerator {
	
	List<Team> generateBiasedTeams(List<Player> players, int minTeamSize, int numberOfTeams) {
		
		if (numberOfTeams * minTeamSize > players.size()) {
			throw new IllegalArgumentException();
		}
		
		//sort players by skill index.
		players.sort(Comparator.comparing(Player::getSkillIndex));
		
		//create team objects
		List<Team> teams = new ArrayList<>();
		for (int i = 0; i < numberOfTeams; i++) {
			teams.add(new Team());
		}
		
		//distribute players across teams
		for (int i = 0; i < players.size(); i++) {
			
			teams.get(i % numberOfTeams).getPlayers().add(players.get(i));
			
			//every 'minTeamSize' iteration, sort teams so that team with lowest skill index gets the best player.
			if (i % numberOfTeams == 0) {
				teams.sort(Comparator.comparing(Team::getTotalSkillIndex).reversed());
			}
		}
		
		return teams;
		
	}
	
}
