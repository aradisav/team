package com.aradisav.team.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	Long id;
	
	@Column
	@OneToMany(mappedBy = "team")
	private Set<Player> players = new HashSet<>();
	@Column
	private String name;
	@Column
	private Integer gamesWon;
	@Column
	private Integer gamesLost;
	@Column
	private Integer gamesPlayed;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGamesWon() {
		return gamesWon;
	}
	
	public void setGamesWon(Integer gamesWon) {
		this.gamesWon = gamesWon;
	}
	
	public Integer getGamesLost() {
		return gamesLost;
	}
	
	public void setGamesLost(Integer gamesLost) {
		this.gamesLost = gamesLost;
	}
	
	public Integer getGamesPlayed() {
		return gamesPlayed;
	}
	
	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public Set<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	public int getTotalSkillIndex() {
		return players.stream().mapToInt(Player::getSkillIndex).sum();
		
	}
	
}
