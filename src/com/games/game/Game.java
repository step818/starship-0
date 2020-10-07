package com.games.game;

import com.games.pieces.*;
//import com.games.pieces.Planet;
//import com.games.pieces.Player;
//import com.games.pieces.Starship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

// Member Variables
Player player1;
Planet earth;
Planet moon;
Starship starship;
HUD display;

//  Business Methods
    public void begin() {
        player1 = new Player();
        earth = new Planet("Earth", new ArrayList<>(Arrays.asList("water", "food")));
        moon = new Planet("Moon", new ArrayList<>(Arrays.asList("fuel", "Elon Musk")));
        starship = new Starship(earth);
        display = new HUD();

        System.out.println(player1.getName());
        // play()
    }

    public void play(){
        while(player1.getHealth() > 0 && starship.getHealth() > 0){
            // keep accepting commands from player and playing
            System.out.println("What's your next command?");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
        }
        // else, loop breaks, ask the player if they'd like to start over
    }
}
