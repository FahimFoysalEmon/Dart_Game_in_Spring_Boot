package com.example.dart_game_in_spring_boot.player;

import com.example.dart_game_in_spring_boot.game.Game;
import com.example.dart_game_in_spring_boot.game.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        Game game = gameRepository.findById(player.getGame().getId()).get();

        System.out.println(game.getFinalPoint());
        Integer sum = 0;
        for (Integer i : player.getPoints())
            sum += i;

        sum+=point;
        System.out.println(sum);

        if (game.getPosition().size() < game.getPlayers().size()) {
            if (sum.equals(game.getFinalPoint()) ) {
                System.out.println("Came here to say hello");
                game.getPosition().add(player.getName());
                player.getPoints().add(point);
                return playerRepository.save(player);
            } else if (sum < game.getFinalPoint()){
                player.getPoints().add(point);
            } else if (sum > game.getFinalPoint()) {
                player.getPoints().remove(player.getPoints().size());
            }
        }
        else {
            throw new RuntimeException(game.getPlayers().size()+ " positions has been filled up for this match");
        }

        return playerRepository.save(player);
    }
}
