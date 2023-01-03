package com.example.dart_game_in_spring_boot.player;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping(value = "/add/player")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @GetMapping(value = "/all/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(value = "/all/players/{id}")
    public Player getPlayer(@PathVariable String id) {
        return playerService.getPlayer(id);
    }


}
