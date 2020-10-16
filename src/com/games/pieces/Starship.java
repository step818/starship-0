package com.games.pieces;

public class Starship {

    private static int health = 100;
    private static int fuel = 100;
    private static int damage = 20;
    private static int fuelUsed = 10;
    public boolean inSpace = false;
    public static Planet currentLocation;
    public static String currentAsteroids;
    private static boolean playerCanUseShield = false;
    private GameArea gameArea;

    public Starship(Planet currentLocation, GameArea gameArea){
        setCurrentLocation(currentLocation);
        this.gameArea = gameArea;
        this.setHealth(100);
        this.setFuel(100);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.gameArea.changeHUDValue("Starship Health", String.valueOf(this.health), String.valueOf(health));
        this.health = health;
    }

    public static int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.gameArea.changeHUDValue("Fuel Level", String.valueOf(this.fuel), String.valueOf(fuel));
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
