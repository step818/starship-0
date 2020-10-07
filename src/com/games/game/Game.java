package com.games.game;

import com.games.pieces.*;
//import com.games.pieces.Planet;
//import com.games.pieces.Player;
//import com.games.pieces.Starship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

//  Business Methods
    public void begin() {
        Player player1 = new Player();
        ArrayList<String> resources = new ArrayList<>(Arrays.asList("water", "gas"));
        Planet earth = new Planet("Earth", resources);
        Planet moon = new Planet("Moon", new ArrayList<>(Arrays.asList("fuel")));
        Starship starship = new Starship();
        HUD display = new HUD();


//        while( the players health is > 0){ keep playing }


        System.out.println(player1.getName());
    }
}
