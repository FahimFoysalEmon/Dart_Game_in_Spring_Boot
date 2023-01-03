package com.example.dart_game_in_spring_boot.game;


import com.example.dart_game_in_spring_boot.player.Player;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class GameController {

    private final GameService gameService;

    @PostMapping(value = "add/game")
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @GetMapping(value = "all/games")
    public List<Game> allGames() {
        return gameService.allGames();
    }
}
