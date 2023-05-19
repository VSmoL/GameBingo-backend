package fi.bingo.gameinfoservice.controllers;

import fi.bingo.gameinfoservice.models.Game;
import fi.bingo.gameinfoservice.services.GameService;
import jakarta.annotation.Resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    @Resource(name = "gameService")
    private GameService gameService;

    @GetMapping
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

}