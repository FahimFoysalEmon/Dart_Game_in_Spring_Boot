package com.example.dart_game_in_spring_boot.game;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameService {

    private final GameRepository gameRepository;

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public List<Game> allGames() {
        return gameRepository.findAll();
    }
}
