package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.Starship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HUD {
    private static Starship starship;
    private static Player player;
    // initialize table


    public HUD(Starship starship, Player player) {
        this.starship = starship;
        this.player = player;
    }

    public void display() {
        System.out.println("++----------------------++----------------------++-----------------++");
        System.out.println("|| " + "Player inventory: " + player.getInventory() +" || " + "Starship health: " + starship.getHealth() + " || " + "Fuel level: " + starship.getFuel() + " ||");
        System.out.println("++----------------------++----------------------++-----------------++");
        System.out.println("Current location: " + starship.getCurrentLocation().getName());
        System.out.println("Starship position: (" + starship.getXpos() + ", " + starship.getYpos() + ") ");
        System.out.println("+----------------------+");

    }


}
