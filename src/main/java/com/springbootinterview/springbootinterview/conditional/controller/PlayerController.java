package com.springbootinterview.springbootinterview.conditional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootinterview.springbootinterview.conditional.entity.Player;

@RestController
public class PlayerController {

	@Autowired
	private Player player;

	@GetMapping("/getPlayer")
	public Player getPlayerDetails() {
		return player;

	}

}
