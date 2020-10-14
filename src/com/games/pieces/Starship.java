package com.games.pieces;

public class Starship {

    private static int health = 100;
    private static int fuel = 100;
    private static int damage = 20;
    private static int fuelUsed = 10;
    public boolean inSpace = false;
    public static Planet currentLocation;
    public static String currentAsteroids;
    private static int Xpos = 1;
    private static int Ypos = 1;
    private static boolean playerCanUseShield = false;

    public Starship(Planet currentLocation){
        setCurrentLocation(currentLocation);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public static int getDamage(){
        return damage;
    }

    public boolean isInSpace() {
        return inSpace;
    }

    public void setInSpace(boolean inSpace) {
        this.inSpace = inSpace;
    }

    public Planet getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Planet location) {
        this.currentLocation = location;
    }

    public static String getCurrentAsteroids() {
        return currentAsteroids;
    }

    public void setCurrentAsteroids(String currentAsteroids) {
        this.currentAsteroids = currentAsteroids;
    }

    public static int getXpos() {
        return Xpos;
    }

    public static void setXpos(int xpos) {
        Xpos = xpos;
    }

    public static int getYpos() {
        return Ypos;
    }

    public static void setYpos(int ypos) {
        Ypos = ypos;
    }

    public static boolean getPlayerCanUseShield() {
        return playerCanUseShield;
    }

    public static void setPlayerCanUseShield(boolean playerCanUseShield) {
        Starship.playerCanUseShield = playerCanUseShield;
    }

    public void takenDamage(int damage){
        setHealth(getHealth() - damage);
    }
    public void burnFuel(){
        setFuel(getFuel() - fuelUsed);
    }
    public void refuel(){
        setFuel(getFuel() + (100-getFuel()));
    }

}
