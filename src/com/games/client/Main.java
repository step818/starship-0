package com.games.client;

import com.games.game.Game;
<<<<<<< HEAD
//import com.games.maps.Earth;
//import com.games.maps.Moon;
=======
import com.games.maps.Earth;
import com.games.maps.Moon;
>>>>>>> 057ba484c3b7dbe839a2319ef53c041601df2f1e

import java.io.IOException;

public class Main {

<<<<<<< HEAD
    public static void main(String[] args) throws InterruptedException {
=======
    public static void main(String[] args) throws IOException {
>>>>>>> 057ba484c3b7dbe839a2319ef53c041601df2f1e
//        start the game here
        System.out.println("Welcome to Starship");
        Game game = new Game();
        game.begin();
<<<<<<< HEAD
//        Earth.draw();
//        Moon.draw();
=======
        Earth.draw();
        Moon.draw();
>>>>>>> 057ba484c3b7dbe839a2319ef53c041601df2f1e
    }
}
