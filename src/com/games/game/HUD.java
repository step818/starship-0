package com.games.game;

import com.games.pieces.Planet;
import com.games.pieces.Player;
import com.games.pieces.Starship;

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
        System.out.print("||                           ||     ");
        System.out.print(output.getPrompt1());
        System.out.println("  ||      "+ output.getprompt2() + "     ||");
        System.out.println("||---------------------------++-----------------------------++-------------------------------------++");
        System.out.println("++---------------------------++--------------------------------------------------------------------++");
        System.out.println("||  Controls: go, take, use  ||  Resources found:" + currentLocation.getResources() + "                                     ||");
        System.out.println("++---------------------------++--------------------------------------------------------------------++");
    }

    public static void prompt1(String prompt1) {
        Output.setPrompt1(prompt1);
    }

    public static void prompt2(String prompt2) {
        Output.setPrompt2(prompt2);
    }

    public Starship getStarship() {
        return starship;
    }

    public void setStarship(Starship starship) {
        this.starship = starship;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }
}
