package com.games.game;

import com.games.pieces.Player;
import com.games.pieces.*;

import java.util.*;

public class TextParser {
    private boolean usedShield;

    // create a list of familiar key verbs
    private Collection<String> verbs = new ArrayList<>(Arrays.asList("go", "use", "take"));
    // do the same for familiar key directional nouns to be able to consult with functions that are looking for nav. input
    private Collection<String> goNouns = new ArrayList<>(Arrays.asList("moon", "up", "right", "left", "down", "straight", "back", "mercury", "mars"));
    // certain functions will need to parse for familiar items to use
    private Collection<String> useNouns = new ArrayList<>(Arrays.asList("laser", "shield", "fuel", "weapon", "food", "super laser", "scrap metal", "Elon Musk"));

    // this function can do all the scanning for input once the game play begins. i.e. After the start menu and username entry.
    public void gamePlayScanner(String input, Player player, ArrayList<Planet> planets, ArrayList<Asteroid> asteroids, ArrayList<Alien> aliens, Starship starship, HUD hud, Level level, HashMap<String, HashMap<String, String>> space) {
        try {
            String[] inputSplit = input.split(" ", 2); // "go up" -> ['go', 'up']
            String verbCommand = inputSplit[0];
            // parse for the verb the user has chosen
            switch(verbCommand) {
                case "go":
                    scanGoNouns(inputSplit[1], planets, asteroids, aliens, starship, space,hud, player);
                    break;
                case "use" :
                    case "take":
                    takeUseDelegator(inputSplit[1], verbCommand, player, starship, hud);
                    break;
                case "show":
                    showStatus(hud, starship);
                    break;
                default:
                    hud.think("What exactly are you saying?");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            hud.think("ArrayOutOfBoundsException: ");
            hud.think(e.getMessage());
            hud.think("Try again");
        }
    }

    // print the user health, fuel, inventory, location
    public static void showStatus(HUD hud,Starship starship) {
        Planet currentLocation = starship.getCurrentLocation();
        hud.display(currentLocation);
    }

    public void scanGoNouns(String noun, ArrayList<Planet> planets,ArrayList<Asteroid> asteroids, ArrayList<Alien> aliens, Starship starship, HashMap<String, HashMap<String, String>> space, HUD hud,Player player) {
// if the argument is a valid goNoun, then call the correct function to output the correct message
        // search the hashmap for VALID destinations
        HashMap<String, String> neighbors= space.get(starship.getCurrentLocation().getName());
        if (neighbors.containsKey(noun)) {
            for(Planet planet : planets){
                if(planet.getName().equals(neighbors.get(noun))){
                    starship.burnFuel();
                    starship.setCurrentLocation(planet);
                    hud.think("You have arrived --> " + starship.getCurrentLocation().getName());
                    // if (we dealing with a planet and not an asteroid nor alien) {
                    Output.uponArrivingOnPlanet(planet);
                    break;
                }
            }
            // if asteroids, make asteroid list, tell pleyer to WATCH OUT!, and allow player to try to dodge out of harms way
            // if player hits asteroid, deduct health. set current location to asteroids
            if(neighbors.get(noun).substring(0, neighbors.get(noun).length()-1).equals("Asteroids")){
                hud.think("Boom! Its an asteroid field!");
                starship.setCurrentAsteroids(neighbors.get(noun));
                potentialAsteroidCollision(asteroids, player, hud, starship);

            } else if (neighbors.get(noun).substring(0, neighbors.get(noun).length()-1).equals("Aliens")) {
                hud.think("Boom! Its an alien ambush!");
                starship.setInSpace(true);
                alienFighting(aliens, player, hud, starship);
            }
        }
        else {
            hud.think("You can\'t go that way.");
        }
    }

    public void potentialAsteroidCollision(ArrayList<Asteroid> asteroids, Player player, HUD hud, Starship starship){
        for(Asteroid asteroid : asteroids) {
            boolean dodged = Output.dodgeAsteroid(asteroid);
            // take damage or not based on a boolean if they dodged correctly
            if(dodged) {
                hud.think("Dodged asteroid! Good job");
            } else {
                if(player.playerHasShield()){
                    hud.think("Looks like you have a shield. Type \'y\' to use shield and take on less damage.");
                    Scanner input = new Scanner(System.in);
                    String response = input.nextLine().toLowerCase();
                    if(response.equals("y")){
                        use("shield", player, hud, starship);
                        if(usedShield){
                            starship.takeHalfDamage();
                            hud.think("Half damage taken");
                        }
                    }
                    else {
                        starship.takenDamage();
                        hud.think("!!!@!%! Ouch!* Starship hit.");
                    }
                }
                else{
                    starship.takenDamage();
                    hud.think("!!!@!%! Ouch!* Starship hit.");
                }
            }
        }
    }
    public void alienFighting(ArrayList<Alien> aliens, Player player, HUD hud, Starship starship){
        for(Alien alien : aliens) {
            int count = 1;
            while(alien.getHealth() > 0) {
                hud.think("Alien ship health: " + alien.getHealth());
                boolean shot = Output.shotAlien(alien);
                if (shot && player.playerHasWeapon()) {
                    alien.setHealth(alien.getHealth() - 50);
                    hud.think("Direct hit! You hit the target!");
                    // while (alien.getHealth > 0) stay with it and kill him. change aliens position
                    // until it dies, see if you can remove it from the list once dead
                }
                else if(shot && !player.playerHasWeapon()){
                    hud.think("Should've grabbed that weapon! Alien ship fires right at you! Starship health: \'-20\'");
                    starship.takenDamage();
                }
                else {
                    hud.think("Missed! Alien ship fired! Starship health: \'-20\'");
                    starship.takenDamage();
                }
                count++;
            }
            hud.think("You killed an alien ship! Success!");
        }
    }
    public void takeUseDelegator(String noun, String verb, Player player, Starship starship, HUD hud) {
// if the argument is valid useNoun, " "
        if (verb.equals("use")) {
            hud.think("you want to use " + noun + " ?");
            whichItemToCallUseWith(noun, player, hud, starship);
        }
        else if (verb.equals("take")){
          take(noun, player, hud);
        }
    }

    // scan the planet's resources and make sure you can take/use whatever noun passed in
    // pop that resource out of the Planet's collection
    public void whichItemToCallUseWith(String noun, Player player, HUD hud, Starship starship){
        for(String word : useNouns){
            if(word.equals(noun)){
                use(noun, player, hud, starship);
            }
        }
    }
    public void use(String noun, Player player, HUD hud, Starship starship){
        switch(noun){
            case "shield":
                usedShield = true;
                break;
            case "fuel":
                starship.refuel();
                // remove fuel from player's inventory
                break;
            case "Elon Musk":
                hud.think("Elon says he doesn't like feeling used.");
                break;
            default:
                usedShield = false;
                hud.think("Looks like you don't have one of those.");
        }
    }
    public void take(String noun, Player player, HUD hud){
        hud.think("You want to take " +noun);
        player.setInventory(noun);
    }
}