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
    public int xPos, yPos;

    public Starship(Planet currentLocation, int xPos, int yPos){
        setCurrentLocation(currentLocation);
        setxPos(xPos);
        setyPos(yPos);
    }

    // Business methods
    public void move(int dx, int dy)
    {
        xPos += dx;
        yPos += dy;
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

    //Getters and Setters
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
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

}
