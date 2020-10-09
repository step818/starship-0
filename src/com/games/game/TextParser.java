package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.*;
import com.games.game.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class TextParser {
    // create a list of familiar key verbs
    private Collection<String> verbs = new ArrayList<>(Arrays.asList("go", "use", "take"));
    // do the same for familiar key directional nouns to be able to consult with functions that are looking for nav. input
    private Collection<String> goNouns = new ArrayList<>(Arrays.asList("moon", "up", "right", "left", "down", "straight", "back", "mercury", "mars"));
    // certain functions will need to parse for familiar items to use
    private Collection<String> useNouns = new ArrayList<>(Arrays.asList("laser", "shield"));

    // this function can do all the scanning for input once the game play begins. i.e. After the start menu and username entry.
    public static void gamePlayScanner(String input, Player player, ArrayList<Planet> planets, Starship starship, HUD display, Level level, HashMap<String, HashMap<String, String>> space) {
        String[] inputSplit = input.split(" ", 2); // "go up" -> ['go', 'up']
        // parse for the verb the user has chosen
        String verbCommand = inputSplit[0];
        switch(verbCommand) {
            case "go":
                if(inputSplit[1].length() > 0){
                    scanGoNouns(inputSplit[1], planets, starship, space);
                }
                else {
                    System.out.println("Where do you want to " + verbCommand +"?");
                }
                break;
            case "use":
                if(inputSplit[1].length() > 0){
                    scanUseNouns(inputSplit[1], verbCommand, player);
                }
                else {
                    System.out.println("How do you " + verbCommand +"?");
                }
                break;
            case "take":
                if(inputSplit[1].length() > 0){
                    scanUseNouns(inputSplit[1], verbCommand, player);
                }
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
        HUD.display();
    }

    public static void scanGoNouns(String noun, ArrayList<Planet> planets, Starship starship, HashMap<String, HashMap<String, String>> space) {
// if the argument is a valid goNoun, then call the correct function to output the correct message
        // search the hashmap for VALID destinations
        if (space.get(starship.getCurrentLocation().getName()).containsKey(noun)) {
            for(Planet planet : planets){
                if(planet.getName().equals(space.get(starship.getCurrentLocation().getName()).get(noun))){
                    starship.setCurrentLocation(planet);
                    System.out.println("You just changed locations: " + starship.getCurrentLocation().getName());
                    break;
                }
            }
        }
        else {
            System.out.println("You can\'t go that way.");
        }
    }

    public static void scanUseNouns(String noun, String verb, Player player) {
// if the argument is valid useNoun, " "
        if (verb.equals("use")) {
            System.out.println("you want to use " + noun + " ?");
        }
        else if (verb.equals("take")){
            System.out.println("you want to take " + noun + " ?");
            player.setInventory(noun);
        }
    }
}
