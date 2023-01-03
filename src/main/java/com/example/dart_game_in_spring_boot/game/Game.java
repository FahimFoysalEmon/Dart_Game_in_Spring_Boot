package com.example.dart_game_in_spring_boot.game;

import com.example.dart_game_in_spring_boot.player.Player;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Game {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String name;
    private Integer finalPoint;
    @ElementCollection
    private List<String> position;

    @OneToMany(mappedBy = "game")
    private List<Player> players;

}
