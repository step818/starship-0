package com.games.game;

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
    public void gamePlayScanner(String input) {
        String[] textCommand = input.split(" ", 2);
        // parse for the verb the user has chosen
        String verbCommand = textCommand[0];
        switch(verbCommand) {
            case "go":
                scanGoNouns(textCommand[1]);
                break;
            case "use":
                scanUseNouns(textCommand[1]);
                break;
            default:
                System.out.println("What exactly are you saying? ");

        }


    }

    public void scanGoNouns(String noun) {

    }

    public void scanUseNouns(String noun) {

    }
}
