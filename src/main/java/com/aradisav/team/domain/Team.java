package com.aradisav.team.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column
    String name;

    @Column
    Integer gamesWon;

    @Column
    Integer gamesLost;

    @Column
    Integer gamesPlayed;

    @Column
    @OneToMany(mappedBy = "team")
    Set<Player> players;


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
}
