package com.games.client;

import com.games.game.Game;

public class Main {

    public static void main(String[] args) {
//        start the game here
        System.out.println("Welcome to Starship");
        Game game = new Game();
        game.begin(80, 24);
    }
}
