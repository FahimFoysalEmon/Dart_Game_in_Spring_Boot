package com.example.dart_game_in_spring_boot.player;

import com.example.dart_game_in_spring_boot.game.Game;
import com.example.dart_game_in_spring_boot.game.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    public void addPlayer(Player player, String gameId) {

        Player playerToBeSaved = new Player();
        playerToBeSaved.setName(player.getName());
        playerToBeSaved.setGame(gameRepository.findById(gameId).get());
        playerRepository.save(playerToBeSaved);


    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(String id) {
        return playerRepository.findById(id).get();
    }

    public Player getPlayerWithPoint(String id, Integer point) {
        Player player = playerRepository.findById(id).get();
        player.getPoints().add(point);
        return playerRepository.save(player);
    }
}
