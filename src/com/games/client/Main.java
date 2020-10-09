package com.games.client;

import com.games.game.Game;

//import com.games.maps.Earth;
//import com.games.maps.Moon;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

//        start the game here
        System.out.println("Welcome to Starship");
        Game game = new Game();
        game.begin();

//        Earth.draw();
//        Moon.draw();

    }
}
