package com.spring.cardgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cardgame.model.PlayerModel;
import com.spring.cardgame.repository.PlayerRepository;

@RestController
public class GameController {

	@Autowired
	private PlayerRepository players;

	@GetMapping("/")
	public String serverHasStarted() {
		return "Server connected";
	}

	@PostMapping("/addPlayerToGame")
	public String addPlayersToGame(@RequestBody String playername) {
		PlayerModel player = new PlayerModel(playername);
		players.save(player);
		return "Players added: " + playername;
	}

	@GetMapping("/error")
	public String error() {
		return "Error";
	}

	@GetMapping("/getPlayer/{playername}")
	public PlayerModel getPlayer(@PathVariable String playername) {
		return players.findByPlayername(playername);
	}


	@GetMapping("/getListOfPlayers")
	public List<PlayerModel> getPlayers() {
		return players.findAll();
	}


	public void addPointsToPlayer(PlayerModel player, int pointsToAdd) {
		PlayerModel playerFromRepo = players.findByPlayername(player.getPlayerName());
		playerFromRepo.setPoints(playerFromRepo.getPoints() + pointsToAdd);
	}



	@DeleteMapping("/removePlayerFromGame/{playername}")
	public String removePlayerFromGame(@PathVariable String playername) {
		PlayerModel playerToRemove = players.findByPlayername(playername);
		players.delete(playerToRemove);
		return "Player removed: " + playername;
	}
}
