package com.spring.cardgame.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CardGame")
public class PlayerModel {

	@Id
	private String playerName;
	private int points;


	public PlayerModel() {
		super();
	}

	public PlayerModel(String playerName) {
		super();
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
