package com.games.client;

import com.games.game.Game;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        start the game here
        System.out.println("Welcome to Starship");
        Game game = new Game();
        game.begin();
    }
}
