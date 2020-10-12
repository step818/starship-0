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
        pressAnyKeyToContinue();
        System.out.println("There is an asteroid headed straight for us. \nMars is the next frontier for humanity.");
        TimeUnit.SECONDS.sleep(2);
        pressAnyKeyToContinue();
        System.out.println("The world needs you, " + Player.getName() + ", to be \nthe one who will fly the Starship to Mars, \nand plant the first seed. ");
        TimeUnit.SECONDS.sleep(2);
        pressAnyKeyToContinue();
        System.out.println("Wow, but why me? I\'m not rea...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("We haven\'t a minute to waste!");
        TimeUnit.SECONDS.sleep(1);
        pressAnyKeyToContinue("Hit ENTER to blast off from Earth");
    }

    public static void askName() {
        System.out.println("Whats your name: ");
    }

    public static void printAsteroidObstacle(Asteroid asteroid){
        System.out.println("A " + asteroid.getSize() + " asteroid just appeared in front of you, \n" +
                "type \'right\' or \'left\' to try to dodge it.");
    }

//    different functions will store sections of the narrative.

//    also, other functions will store responses to certain inputs guided from the text parser
    public static void uponArrivingOnPlanet(Planet planet) {
        String name = planet.getName();
        ArrayList<String> resources = planet.getResources();
        System.out.println(name + " has: " + resources);
    }

    public static boolean dodgeAsteroid(Asteroid asteroid) {
        String location = asteroid.getPosition();
        System.out.println("location: " + location);
        Scanner scan = new Scanner(System.in);
        printAsteroidObstacle(asteroid);
        String input = scan.nextLine();
        return input.equals(location);
    }

    public static boolean shotAlien(Alien alien) {
        String location = alien.getPosition();
        System.out.println("location: " + location);
        Scanner scan = new Scanner(System.in);
        System.out.println("An alien is threatening you, \n" +
                "type \'left\', \'right\', \'bottom\', or \'up\' to try to shoot them.");
        String input = scan.nextLine();
        return input.equals(location);
    }
}