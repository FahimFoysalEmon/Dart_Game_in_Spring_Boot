package com.example.dart_game_in_spring_boot.game;

import com.example.dart_game_in_spring_boot.player.Player;
import com.example.dart_game_in_spring_boot.player.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;


    public void addGame(Game game) {

        List<Player> players = game.getPlayers();
        System.out.println(game.getPlayers().get(0).getName());
        gameRepository.save(game);

        players.forEach(player -> {
            player.setGame(game);
            playerRepository.save(player);
        });

    }

    public List<Game> allGames() {
        return gameRepository.findAll();
    }
}
