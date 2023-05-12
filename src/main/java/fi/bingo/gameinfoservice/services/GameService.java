package fi.bingo.gameinfoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bingo.gameinfoservice.models.Game;
import fi.bingo.gameinfoservice.repositories.GameRepository;

import java.util.List;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<Game> list(){
        return gameRepository.findAll();
    }

}
