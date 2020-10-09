package com.games.game;

import com.games.pieces.*;
//import com.games.pieces.Planet;
//import com.games.pieces.Player;
//import com.games.pieces.Starship;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Game {

// Member Variables
Player player1;
Planet earth;
Planet moon;
Planet mercury;
Planet mars;
ArrayList<Planet> planets = new ArrayList<>();
Starship starship;
HUD display;
Level level1;

//  Business Methods
    public void begin() throws InterruptedException {
        player1 = new Player();
        earth = new Planet("Earth", new ArrayList<>(Arrays.asList("water", "food")));
        moon = new Planet("Moon", new ArrayList<>(Arrays.asList("fuel", "Elon Musk")));
        mercury = new Planet("Mercury", new ArrayList<>(Arrays.asList("super laser", "shield")));
        mars = new Planet("Mars", new ArrayList<>());
        planets.add(earth);
        planets.add(moon);
        planets.add(mercury);
        planets.add(mars);
        starship = new Starship(earth);
        display = new HUD(starship, player1);
        level1 = new Level();

        System.out.println(player1.getName());
        play(player1, planets, starship, display, level1);
    }

    public void play(Player player, ArrayList<Planet> planets, Starship starship, HUD display, Level level) throws InterruptedException {
        Output.introNarrative();
        while(player1.getHealth() > 0 && starship.getHealth() > 0){
            // keep accepting commands from player and playing
            System.out.println("What's your next command?");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            TextParser.gamePlayScanner(command, player, planets, starship, display, level);
        }
        // else, loop breaks, ask the player if they'd like to start over
        if(player1.getHealth() <= 0) {
            // player died, start over?
        }
        else if (starship.getHealth() <= 0) {
            // starship exploded, start over?
        }

    }
}
