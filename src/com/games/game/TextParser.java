package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.*;
import com.games.game.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TextParser {
    // create a list of familiar key verbs
    private Collection<String> verbs = new ArrayList<>(Arrays.asList("go", "use"));
    // do the same for familiar key directional nouns to be able to consult with functions that are looking for nav. input
    private Collection<String> goNouns = new ArrayList<>(Arrays.asList("moon", "up", "right", "left", "down", "straight", "back", "mercury", "mars"));
    // certain functions will need to parse for familiar items to use
    private Collection<String> useNouns = new ArrayList<>(Arrays.asList("laser", "shield"));

    // this function can do all the scanning for input once the game play begins. i.e. After the start menu and username entry.
    public static void gamePlayScanner(String input, Player player, ArrayList<Planet> planets, Starship starship, HUD display, Level level) {
        String[] inputSplit = input.split(" ", 2);
        // parse for the verb the user has chosen
        String verbCommand = inputSplit[0];
        switch(verbCommand) {
            case "go":
                scanGoNouns(inputSplit[1], planets, starship);
                break;
            case "use":
                scanUseNouns(inputSplit[1]);
                break;
            case "show":
                showStatus();
                break;
            default:
                System.out.println("What exactly are you saying? ");
        }
    }

    // print the user health, fuel, inventory, location
    public static void showStatus() {
        System.out.println("Show status called.");
        HUD.display();
    }

    public static void scanGoNouns(String noun, ArrayList<Planet> planets, Starship starship) {
// if the argument is a valid goNoun, then call the correct function to output the correct message
        System.out.println("you want to go " + noun + " ?");
        for(Planet planet : planets){
      /*      System.out.println("Here's a planet");
            System.out.println(planet.getName());
            System.out.println(noun);*/
            if(planet.getName().toLowerCase().equals(noun)){
                starship.setCurrentLocation(planet);
                System.out.println("You just changed locations: " + starship.getCurrentLocation().getName());
            }
        }
    }

    public static void scanUseNouns(String noun) {
// if the argument is valid useNoun, " "
        System.out.println("you want to use " + noun + " ?");
    }
}
