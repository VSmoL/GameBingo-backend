package fi.bingo.gameinfoservice.services;

import org.springframework.stereotype.Service;

import fi.bingo.gameinfoservice.models.Game;

import java.util.List;

@Service("gameService")
public interface GameService {
    
    List<Game> getAllGames();

}
