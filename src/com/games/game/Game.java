package com.games.game;

import com.games.pieces.*;
//import com.games.pieces.Planet;
//import com.games.pieces.Player;
//import com.games.pieces.Starship;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


import java.util.*;
import java.util.Random;

public class Game {

// Member Variables
    static Player player1;
    Planet earth;
    Planet moon;
    Planet venus;
    Planet mercury;
    Planet mars;
    Planet obstacle1;
    Planet obstacle2;
    ArrayList<Planet> planets = new ArrayList<>();
    ArrayList<Asteroid> asteroids;
    ArrayList<Alien> aliens;
    Starship starship;
    HUD hud;
    Output output = new Output();
    Level level1;
    TextParser parser;
    public static HashMap<String, HashMap<String, String>> space = new HashMap<>();

    private Rectangle gameScreenRec;
    private GameArea gameScreen;
    private boolean isRunning;
    private static final int mapWidth = 100;
    private static final int mapHeight = 100;
    private int framesPerSecond = 60;
    private int timePerLoop = 1000000000 / framesPerSecond;

    //private static final int HEIGHT = 10;
//   private static final int WIDTH = 10;


    public HashMap<String, HashMap<String, String>> drawGame() {
// Earths neighbors
        HashMap<String, String> earthNeighbors = new HashMap<>();

        earthNeighbors.put("right", "Moon");
        space.put("Earth", earthNeighbors);
// Moon neighbors
        HashMap<String, String> moonNeighbors = new HashMap<>();

        moonNeighbors.put("left", "Earth");
        moonNeighbors.put("up", "Venus");
        space.put("Moon", moonNeighbors);
// Venus
        HashMap<String, String> venusNeighbors = new HashMap<>();

        venusNeighbors.put("down", "Moon");
        venusNeighbors.put("up", "Mercury");
        space.put("Venus", venusNeighbors);
// Mercury neighbors
        HashMap<String, String> mercuryNeighbors = new HashMap<>();

        mercuryNeighbors.put("down", "Venus");
        mercuryNeighbors.put("left", "Asteroids1");
        space.put("Mercury", mercuryNeighbors);
// Asteroids1 neighbors
        HashMap<String, String> asteroid1Neighbors = new HashMap<>();

        asteroid1Neighbors.put("right", "Mercury");
        asteroid1Neighbors.put("up", "Aliens1");
        space.put("Asteroids1", asteroid1Neighbors);
// aliens
        HashMap<String, String> alien1Neighbors = new HashMap<>();

        alien1Neighbors.put("down", "Asteroids1");
        alien1Neighbors.put("up", "Mars");
        space.put("Aliens1", alien1Neighbors);
// Mars
        HashMap<String, String> marsNeighbors = new HashMap<>();

        marsNeighbors.put("down", "Aliens1");
        space.put("Mars", marsNeighbors);

        return space;
    }

//  Business Methods
    public void begin(int screenWidth, int screenHeight) throws InterruptedException {
        player1 = new Player('@', Color.yellow, 10, 10);
        earth = new Planet("Earth", new ArrayList<>(Arrays.asList("water", "food")));
        moon = new Planet("Moon", new ArrayList<>(Arrays.asList("fuel", "Elon Musk", "weapon")));
        venus = new Planet("Venus", new ArrayList<>(Arrays.asList("fuel", "scrap metal")));
        mercury = new Planet("Mercury", new ArrayList<>(Arrays.asList("super laser", "shield")));
        obstacle1 = new Planet("Asteroids1", new ArrayList<>(Arrays.asList("speed booster")));
        obstacle2 = new Planet("Aliens1", new ArrayList<>(Arrays.asList("bb gun")));
        mars = new Planet("Mars", new ArrayList<>());
        planets.add(earth);
        planets.add(moon);
        planets.add(venus);
        planets.add(mercury);
        planets.add(mars);
        planets.add(obstacle1);
        planets.add(obstacle2);
        asteroids = createAsteroids(3, "large");
        aliens = createAliens(3);
        starship = new Starship(earth);
        hud = new HUD(starship, player1, output);
        level1 = new Level();
        parser = new TextParser();
        space = drawGame();
        System.out.println(player1.getName());
        play(player1, planets, asteroids, aliens, starship, hud, level1);
        run();
    }

    public void play(Player player, ArrayList<Planet> planets, ArrayList<Asteroid> asteroids, ArrayList<Alien> aliens, Starship starship, HUD hud, Level level) throws InterruptedException {
//        output.introNarrative(player);
        String initialThoughts = "Welcome to Starship.";
        hud.prompt1(initialThoughts);
        while(player1.getHealth() > 0 && starship.getHealth() > 0){
            this.hud.display(starship.getCurrentLocation());
            // keep accepting commands from player and playing
            System.out.print("|| Input: ");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            parser.gamePlayScanner(command, player, planets, asteroids, aliens, starship, hud, level, space);
            // else, loop breaks, ask the player if they'd like to start over
            if(player1.getHealth() <= 0) {
                // player died, start over?
                System.out.println("player died.");
            }
            else if (starship.getHealth() <= 0) {
                // starship exploded, start over?
                System.out.println("Starship exploded.");
            }
        }
    }

    public ArrayList<Asteroid> createAsteroids(int numOfRocks, String size){
        ArrayList<Asteroid> asteroids = new ArrayList<>();
        for(int i = 0; i < numOfRocks; i++){
            String position = "left";
            // randomly pick a position i.e. "left", "down"
            // TODO: give the player more or less options for dodging to make difficulty variable
            // large - player has 25% chance of dodging. options: up, down, left, right
            // medium - player has 33% chance of dodging. options: up, left, right
            // small - player has 50% chance of dodging. options: left, right
            Random rand = new Random();
            int random = rand.nextInt(12);
            if(random < 6 && random % 2 == 0) {
                position = "right";
            } else if (random < 6 && random % 2 != 0) {
                position = "left";
            } else if (random >= 6 && random % 2 == 0) {
                position = "up";
            } else if (random >= 6 && random % 2 != 0) {
                position = "down";
            }
            asteroids.add(new Asteroid(size, position));
        }
        return asteroids;
    }

    public ArrayList<Alien> createAliens(int numOfAliens){
        ArrayList<Alien> aliens = new ArrayList<>();
        for(int i = 0; i < numOfAliens; i++){
            // randomly pick left or right or up or down
            //for now, i will hard code it to down
            String position = "left";
            Random rand = new Random();
            int random = rand.nextInt(12);
            if(random < 6 && random % 2 == 0) {
                position = "right";
            } else if (random < 6 && random % 2 != 0) {
                position = "left";
            } else if (random >= 6 && random % 2 == 0) {
                position = "up";
            } else if (random >= 6 && random % 2 != 0) {
                position = "down";
            }
            aliens.add(new Alien(position));
        }
        return aliens;
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
        //gameScreen.pointCameraAt(world, player.getX(), player.getY());
        gameScreen.pointCameraAt(player1, player1.getPlayerPositionX(), player1.getPlayerPositionY());
        //gameScreen.drawDynamicLegend(gameViewArea, world, tileData, creatureData);
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
}
