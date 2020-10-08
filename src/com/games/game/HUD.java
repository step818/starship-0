package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.Starship;

public class HUD {

    public static void display() {
        System.out.println("Starship health: " + Starship.getHealth());
        System.out.println("Fuel level: " + Starship.getFuel());
        System.out.println("Player inventory: " + Player.getInventory());
        System.out.println("Current location: " + Starship.getCurrentLocation().getName());
        System.out.println("Starship position: (" + Starship.getXpos() + ", " + Starship.getYpos() + ") ");
    }
}
