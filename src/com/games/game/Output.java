package com.games.game;

import com.games.pieces.Player;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Output {

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
        System.out.println("There is an asteroid headed straight for us and the only way life as we know it will survive is if we move to Mars.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\'Enter\' to continue.");
        String doneReading = scan.next();
        System.out.println("I need you," + Player.getName() + " to be the one who will fly the Starship to Mars, and plant the first seed. ");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Wow, but why me? I\'m not rea...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("We haven\'t a minute to waste! There\'s only one way you can possibly move from this screen and that\'s to the enter button.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\'Enter\' to continue.");
        doneReading = scan.next();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Hit enter the blast off from Earth");
        doneReading = scan.next();
    }

    public static void askName() {
        System.out.println("Whats your name: ");
    }

//    different functions will store sections of the narrative.

//    also, other functions will store responses to certain inputs guided from the text parser

}
