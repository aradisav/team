package com.aradisav.team.service;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aradisav.team.domain.Player;
import com.aradisav.team.domain.Team;

/**
 * @author aradisavljevic
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamGeneratorTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TeamGenerator teamGenerator;
	
	private List<Player> players;
	
	@Before
	public void setUp() {
		Random rand = new Random();
		players = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			Player player = new Player();
			player.setSkillIndex(rand.nextInt(9));
			players.add(player);
		}
		
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void generateBiasedTeams() {
		int numberOfTeams = 2;
		int teamSize = 5;
		
		List<Team> teams = teamGenerator.generateBiasedTeams(players, teamSize, numberOfTeams);
		
		assertNotNull(teams);
		assertThat(teams.size(), is(numberOfTeams));
		for (Team t : teams) {
			assertThat(t.getPlayers().size(), greaterThanOrEqualTo(teamSize));
			log.info("" + t.getTotalSkillIndex());
		}
		
	}
}