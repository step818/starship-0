package com.games.pieces;

import java.util.ArrayList;

public class Starship {
    private ArrayList<String> inventory = new ArrayList<>();
    private static int health = 100;
    private static int fuel = 100;
    private static int damage = 20;
    private static int fuelUsed = 10;
    public boolean inSpace = false;
    public static Planet currentLocation;
    public static String currentAsteroids;
    private static boolean playerCanUseShield = false;
    public int xPos, yPos;

    public Starship(GameArea gameArea, Planet currentLocation, int xPos, int yPos){
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

    public void pickUp(GameArea gameArea, ArrayList<Planet> planets) {
        for(Planet planet : planets) {
            if(getxPos() == planet.getX() && getyPos() == planet.getY() && planet.getResources().size()>0) {
                System.out.println("You made it");
                ArrayList<String> planetsResources = planet.getResources();
                inventory.add(planetsResources.get(0));
                planetsResources.remove(0);
                System.out.println("Inventory: " + inventory);
            }
        }
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

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public static boolean getPlayerCanUseShield() {
        return playerCanUseShield;
    }

    public static void setPlayerCanUseShield(boolean playerCanUseShield) {
        Starship.playerCanUseShield = playerCanUseShield;
    }

}
