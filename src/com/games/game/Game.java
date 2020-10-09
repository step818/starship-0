package com.games.game;

import com.games.pieces.*;
//import com.games.pieces.Planet;
//import com.games.pieces.Player;
//import com.games.pieces.Starship;

//<<<<<<< HEAD
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
//=======
import java.lang.reflect.Array;
//>>>>>>> 0727ebfdd3107880b1deea9bc14edb0e3ffa996e
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Game {

    // Member Variables
    Player player1;
    Planet earth;
    Planet moon;
    Planet mercury;
    Planet mars;
    ArrayList<Planet> planets = new ArrayList<>();
    Starship starship;
    HUD display;
    Level level1;

    private Rectangle gameScreenRec;
    private GameArea gameScreen;
    private boolean isRunning;
    private static final int mapWidth = 100;
    private static final int mapHeight = 100;
    private int framesPerSecond = 60;
    private int timePerLoop = 1000000000 / framesPerSecond;

    //  Business Methods
    public void begin(int screenWidth, int screenHeight) {
        gameScreen = new GameArea(new Rectangle(screenWidth, screenHeight), new Rectangle(mapWidth, mapHeight-5));
        player1 = new Player('@', "yellow", 10, 10);

        earth = new Planet("Earth", new ArrayList<>(Arrays.asList("water", "food")));
        moon = new Planet("Moon", new ArrayList<>(Arrays.asList("fuel", "Elon Musk")));
        mercury = new Planet("Mercury", new ArrayList<>(Arrays.asList("super laser", "shield")));
        mars = new Planet("Mars", new ArrayList<>());
        planets.add(earth);
        planets.add(moon);
        planets.add(mercury);
        planets.add(mars);
        starship = new Starship(earth);
        display = new HUD();
        level1 = new Level();

        System.out.println(player1.getName());
//<<<<<<< HEAD
        //play();
        run();
    }


    public void processInput() {
        InputEvent event = gameScreen.getNextInput();
        if (event instanceof KeyEvent) {
            KeyEvent keypress = (KeyEvent)event;
            switch (keypress.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    player1.move(-1, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    player1.move(1, 0); break;
                case KeyEvent.VK_UP:
                    player1.move(0, -1);
                    break;
                case KeyEvent.VK_DOWN:
                    player1.move(0, 1);
                    break;
            }
        } else if (event instanceof MouseEvent) {
            //
        }
    }

    public void render(){
        gameScreen.pointCameraAt(player1, player1.getX(), player1.getY());
        gameScreen.refresh();
    }

    public void run() {
        isRunning = true;

        while(isRunning) {
            long startTime = System.nanoTime();

            processInput();
            render();

            long endTime = System.nanoTime();

            long sleepTime = timePerLoop - (endTime-startTime);

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime/1000000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void play() {
        while (player1.getHealth() > 0 && starship.getHealth() > 0) {
//=======
            play(player1, planets, starship, display, level1);
        }
    }


        public void play(Player player, ArrayList<Planet> planets, Starship starship, HUD display, Level level)
        {
            while(player1.getHealth() > 0 && starship.getHealth() > 0){
//>>>>>>> 0727ebfdd3107880b1deea9bc14edb0e3ffa996e
                // keep accepting commands from player and playing
                System.out.println("What's your next command?");
                Scanner input = new Scanner(System.in);
                String command = input.nextLine();
                TextParser.gamePlayScanner(command, player, planets, starship, display, level);
            }
            // else, loop breaks, ask the player if they'd like to start over
            if (player1.getHealth() <= 0) {
                // player died, start over?
            } else if (starship.getHealth() <= 0) {
                // starship exploded, start over?
            }

        }


        //public void setPreferredSize(Dimension dimension) {
        //  dimension.height
    }

