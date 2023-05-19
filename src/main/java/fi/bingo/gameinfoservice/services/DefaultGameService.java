package fi.bingo.gameinfoservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bingo.gameinfoservice.models.Game;
import fi.bingo.gameinfoservice.repositories.GameRepository;

@Service("gameService")
public class DefaultGameService implements GameService {
    
    @Autowired
    private GameRepository gameRepository;
    
    @Override
    public List<Game> getAllGames() {
        List<Game> gameList = gameRepository.findAll();
        return gameList;
    }
}
