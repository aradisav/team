package com.aradisav.team.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.aradisav.team.domain.Player;
import com.aradisav.team.domain.Team;

@Service
@Validated
public class TeamGenerator {
	
	@NotNull List<Team> generateBiasedTeams(@NotEmpty List<Player> players, @Min(2) int minTeamSize, @Min(2) int numberOfTeams) {
		
		if (numberOfTeams * minTeamSize > players.size()) {
			return Collections.emptyList();
		}
		
		//sort players by skill index.
		players.sort(Comparator.comparing(Player::getSkillIndex).reversed());
		
		//create team objects
		List<Team> teams = new ArrayList<>();
		for (int i = 0; i < numberOfTeams; i++) {
			teams.add(new Team());
		}
		
		//distribute players across teams
		for (int i = 0; i < players.size(); i++) {
			
			//every 'minTeamSize' iteration, sort teams so that team with lowest skill index gets the best player.
			if (i != 0 && i % numberOfTeams == 0) {
				teams.sort(Comparator.comparing(Team::getTotalSkillIndex));
			}
			
			teams.get(i % numberOfTeams).getPlayers().add(players.get(i));
			
		}
		
		return teams;
		
	}
	
}
