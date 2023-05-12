package fi.bingo.gameinfoservice.controllers;

import fi.bingo.gameinfoservice.models.Game;
import fi.bingo.gameinfoservice.repositories.GameRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private GameRepository gameRepository;

    @GetMapping
    public Iterable<Game> findAll() {
        return gameRepository.findAll();
    }

}