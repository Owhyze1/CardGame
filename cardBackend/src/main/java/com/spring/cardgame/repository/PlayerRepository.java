package com.spring.cardgame.repository;

//import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.cardgame.model.PlayerModel;

@Repository
public interface PlayerRepository extends MongoRepository<PlayerModel, Integer> {

	 
	PlayerModel findByPlayername(String playername);
}
