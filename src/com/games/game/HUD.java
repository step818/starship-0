package com.games.game;

import com.games.pieces.Planet;
import com.games.pieces.Player;
import com.games.pieces.Starship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HUD {
    private Starship starship;
    private Player player;
    private Output output;
    // initialize table


    public HUD(Starship starship, Player player, Output output) {
        this.starship = starship;
        this.player = player;
        this.output = output;
    }

    public void display(Planet currentLocation) {
        System.out.println("++---------------------------++-----------------------------++-------------------------------------++");
        System.out.println("||  Player inventory: " + player.getInventory() +"     ||    Starship health: " + starship.getHealth() + "     ||    Fuel level: " + starship.getFuel() + "                  ||");
        System.out.println("++---------------------------++-----------------------------++-------------------------------------++");
        System.out.println("+----------------------------++-----------------------------++-------------------------------------++");
        System.out.println("||  Current location: " + currentLocation.getName() + "  ||          HAL 9000           ||  Directions: left, right, up, down  ||" );
        System.out.println("||                           ||            ((0))            ++-------------------------------------||");
        System.out.println("||                           ||  "+ output.getMessage()+"       ||      What\'s your next command?     ||");
        System.out.println("||---------------------------++-----------------------------++-------------------------------------++");
        System.out.println("++---------------------------++--------------------------------------------------------------------++");
        System.out.println("||  Controls: go, take, use  ||  Resources found:" + currentLocation.getResources() + "                                     ||");
        System.out.println("++---------------------------++--------------------------------------------------------------------++");
    }

    public void think(String thoughts) {
        output.setMessage(thoughts);
    }

}
