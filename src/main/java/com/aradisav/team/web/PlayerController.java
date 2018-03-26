package com.aradisav.team.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aradisav.team.service.TeamGenerator;

/**
 * @author aradisavljevic
 */

@Controller
public class PlayerController {
	private final TeamGenerator teamGenerator;
	
	@Autowired
	public PlayerController(TeamGenerator teamGenerator) {
		this.teamGenerator = teamGenerator;
	}
	
	@GetMapping("/players")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return "HELLO";
	}
	
}
