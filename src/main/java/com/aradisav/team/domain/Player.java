package com.aradisav.team.domain;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String username;

    @Column
    Integer skillIndex;


    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSkillIndex() {
        return skillIndex;
    }

    public void setSkillIndex(Integer skillIndex) {
        this.skillIndex = skillIndex;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
