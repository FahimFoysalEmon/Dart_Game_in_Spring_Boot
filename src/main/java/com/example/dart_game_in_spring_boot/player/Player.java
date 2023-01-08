package com.example.dart_game_in_spring_boot.player;


import com.example.dart_game_in_spring_boot.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Player {


    @Id
    private String id;
    private String name;
    @ElementCollection
    private List<Integer> points;

    @JsonIgnore
    @ManyToOne
    private Game game;

}
