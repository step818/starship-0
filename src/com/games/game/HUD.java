package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.Starship;

public class HUD {
    private static Starship starship;
    private static Player player;

    public HUD(Starship starship, Player player) {
        this.starship = starship;
        this.player = player;
    }

    public static void display() {
        System.out.println("Starship health: " + starship.getHealth());
        System.out.println("Fuel level: " + starship.getFuel());
        System.out.println("Player inventory: " + player.getInventory());
        System.out.println("Current location: " + starship.getCurrentLocation().getName());
        System.out.println("Starship position: (" + starship.getXpos() + ", " + starship.getYpos() + ") ");
    }
}
