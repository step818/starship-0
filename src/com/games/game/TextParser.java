package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.Starship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TextParser {
    // create a list of familiar key verbs
    private Collection<String> verbs = new ArrayList<>(Arrays.asList("go", "use"));
    // do the same for familiar key directional nouns to be able to consult with functions that are looking for nav. input
    private Collection<String> goNouns = new ArrayList<>(Arrays.asList("moon", "up", "right", "left", "down", "straight", "back"));
    // certain functions will need to parse for familiar items to use
    private Collection<String> useNouns = new ArrayList<>(Arrays.asList("laser", "shield"));

    // this function can do all the scanning for input once the game play begins. i.e. After the start menu and username entry.
    public static void gamePlayScanner(String input) {
        String[] inputSplit = input.split(" ", 2); // "go up" -> ['go', 'up']
        // parse for the verb the user has chosen
        String verbCommand = inputSplit[0];
        switch(verbCommand) {
            case "go":
                if(inputSplit[1].length() > 0){
                    scanGoNouns(inputSplit[1]);
                }
                else {
                    System.out.println("Where do you want to " + verbCommand +"?");
                }
                break;
            case "use":
                if(inputSplit[1].length() > 0){
                    scanUseNouns(inputSplit[1]);
                }
                else {
                    System.out.println("How do you " + verbCommand +"?");
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

    public static void scanGoNouns(String noun) {
// if the argument is a valid goNoun, then call the correct function to output the correct message
        System.out.println("you want to go " + noun + " ?");
    }

    public static void scanUseNouns(String noun) {
// if the argument is valid useNoun, " "
        System.out.println("you want to use " + noun + " ?");
    }
}
