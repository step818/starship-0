package com.games.game;

import com.games.pieces.Alien;
import com.games.pieces.Asteroid;
import com.games.pieces.Planet;
import com.games.pieces.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Output {

    public static void pressAnyKeyToContinue(String message) {
        System.out.println(message);
        try {
            System.in.read();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void pressAnyKeyToContinue() {
        System.out.println("Press ENTER key to continue...");
        try {
            System.in.read();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void introNarrative() throws InterruptedException {
        // The story begins, fill the user in with their mission
        Scanner scan = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("ring ring...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Hello...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Hi " + Player.getName() + ". ");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("This is Elon Musk calling.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("I need your help...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Okkkkkkkkkk...");
        TimeUnit.SECONDS.sleep(1);
        pressAnyKeyToContinue();
        System.out.println("There is an asteroid headed straight for us and the only way life as we know it will survive is if we move to Mars.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("I world needs you, " + Player.getName() + ", to be the one who will fly the Starship to Mars, and plant the first seed. ");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Wow, but why me? I\'m not rea...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("We haven\'t a minute to waste! There\'s only one way you can possibly move from this screen and that\'s to the enter button.");
        TimeUnit.SECONDS.sleep(1);
        pressAnyKeyToContinue("Hit ENTER to blast off from Earth");
    }

    public static void askName() {
        System.out.println("Whats your name: ");
    }

    public static void printAsteroidObstacle(Asteroid asteroid){
        System.out.println("There is a " + asteroid.getSize() + " asteroid to your " + asteroid.getPosition() + ". Steer the opposite direction of the asteroid to avoid Starship damage.");
    }
    public static void printAlienObstacle(Alien alien){
        System.out.println("There is a an alien in your way. Shoot it to continue on without damage to your Starship and your health.");
    }
//    different functions will store sections of the narrative.

//    also, other functions will store responses to certain inputs guided from the text parser
    public static void uponArrivingOnPlanet(Planet planet) {
        String name = planet.getName();
        ArrayList<String> resources = planet.getResources();
        System.out.println(name + " has: " + resources);
    }
}
