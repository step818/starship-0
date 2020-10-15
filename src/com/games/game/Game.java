package com.games.game;

import com.games.pieces.*;
//import com.games.pieces.Planet;
//import com.games.pieces.Player;
//import com.games.pieces.Starship;

import java.awt.*;
import java.awt.desktop.OpenURIEvent;
import java.lang.reflect.Array;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Random;

public class Game {

    // Member Variables
    private static Player player;
    private static ArrayList<Planet> planets;
    private static ArrayList<Asteroid> asteroids;
    private static ArrayList<Alien> aliens;
    private static Starship starship;
    private static HUD hud;
    private static Output output;
    private static Level level1;
    private static TextParser parser;
    private static HashMap<String, HashMap<String, String>> space;
    private static Rectangle gameScreenRec;
    private static GameArea gameScreen;
    private static boolean isRunning;
    private static final int mapWidth = 100;
    private static final int mapHeight = 100;
    private static int framesPerSecond = 60;
    private static int timePerLoop = 1000000000 / framesPerSecond;

    static Game game = new Game();

    private Game(){

    }

    public static Game getGameInstance(){
        return game;
    }

    public static Player getPlayer() {
        return player;
    }
    public static void setPlayer() {
        player = new Player('@', Color.yellow, 10, 10);
    }

    public static ArrayList<Planet> getPlanets() {
        return planets;
    }
    public static void setPlanets() {
        planets = new ArrayList<>();
        planets.add(new Planet("Earth", new ArrayList<>(Arrays.asList("water", "food"))));
        planets.add(new Planet("Moon", new ArrayList<>(Arrays.asList("fuel", "Elon Musk", "weapon"))));
        planets.add(new Planet("Venus", new ArrayList<>(Arrays.asList("fuel", "scrap metal"))));
        planets.add(new Planet("Mercury", new ArrayList<>(Arrays.asList("super laser", "shield"))));
        planets.add(new Planet("Mars", new ArrayList<>()));
        planets.add(new Planet("Asteroids1", new ArrayList<>(Arrays.asList("speed booster"))));
        planets.add(new Planet("Aliens1", new ArrayList<>(Arrays.asList("bb gun"))));
    }

    public static ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }
    public static void setAsteroids() {
        asteroids = game.createAsteroids(3, "large");
    }

    public static ArrayList<Alien> getAliens() {
        return aliens;
    }
    public static void setAliens() {
        aliens = game.createAliens(3);
    }

    public static Starship getStarship() {
        return starship;
    }
    public static void setStarship() {
        starship = new Starship(planets.get(0));
    }

    public static HUD getHud() {
        return hud;
    }
    public static void setHud() {
        hud = new HUD(starship, player, output);
    }

    public static Output getOutput() {
        return output;
    }
    public static void setOutput() {
        output = new Output();
    }

    public static Level getLevel1() {
        return level1;
    }
    public static void setLevel1() {
        level1 = new Level();
    }

    public static TextParser getParser() {
        return parser;
    }
    public static void setParser() {
        parser = new TextParser();
    }

    public static HashMap<String, HashMap<String, String>> getSpace() {
        return space;
    }
    public static void setSpace() {
        space = new HashMap<String, HashMap<String, String>>();
        space = game.drawGame();
    }

    //  Business Methods
    public void begin(int screenWidth, int screenHeight) throws InterruptedException {
        setPlayer();
        setPlanets();
        setAsteroids();
        setAliens();
        setStarship();
        setHud();
        setOutput();
        setParser();
        setSpace();
        gameScreen = new GameArea(new Rectangle(screenWidth, screenHeight), new Rectangle(mapWidth, mapHeight-5));
        play();
    }

    public void play() throws InterruptedException {
        getOutput().introNarrative(getPlayer());
        String initialThoughts = "Welcome to Starship.";
        getHud().prompt1(initialThoughts);
        //run();
        while(getStarship().getFuel() > 0 && getStarship().getHealth() > 0 && getStarship().getCurrentLocation() != getPlanets().get(4)){
            getHud().display(getStarship().getCurrentLocation());
            // keep accepting commands from player and playing
            System.out.print("|| Input: ");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            getParser().gamePlayScanner(command, player, planets, asteroids, aliens, starship, hud, level1, space);
        }
         // else, loop breaks, ask the player if they'd like to start over
        if(starship.getFuel() <= 0 || starship.getHealth() <= 0) {
            if(starship.getCurrentLocation() == getPlanets().get(4)){
                System.out.println("You made it to Mars! Congratulations.");
            }
            else{
                System.out.println("Game over. Enter \'y\' to play again or \'n\' to exit.");
            }
            restartOrClose();
        }
    }

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

    public void restartOrClose() throws InterruptedException{
        if(startOverPrompt()){
            this.begin(80, 24);
        }
        else{
            System.exit(0);
        }
    }
    public boolean startOverPrompt(){
        Scanner input = new Scanner(System.in);
        String command = input.nextLine().toLowerCase();
        while(!command.equals("y") && !command.equals("n")){
            System.out.println("Invalid choice. Enter y or n. \n Do you want to try again?");
            command = input.nextLine().toLowerCase();
        }
        if(command.equals("y")){
            System.out.println("You entered play again");
            return true;
        }
        else {
            System.out.println("Game exiting.");
            return false;
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


    // game ascii board methods
    public void processInput() {
        InputEvent event = gameScreen.getNextInput();
        if (event instanceof KeyEvent) {
            KeyEvent keypress = (KeyEvent)event;
            switch (keypress.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    getPlayer().move(-1, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    getPlayer().move(1, 0); break;
                case KeyEvent.VK_UP:
                    getPlayer().move(0, -1);
                    break;
                case KeyEvent.VK_DOWN:
                    getPlayer().move(0, 1);
                    break;
            }
        } else if (event instanceof MouseEvent) {
            //
        }
    }
    public void render(){
        // gameScreen.pointCameraAt(world, player.getX(), player.getY());
        gameScreen.pointCameraAt(getPlayer(), getPlayer().getPlayerPositionX(), getPlayer().getPlayerPositionY());
        // gameScreen.drawDynamicLegend(gameViewArea, world, tileData, creatureData);
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
