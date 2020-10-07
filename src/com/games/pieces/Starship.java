package com.games.pieces;

public class Starship {

    public int health = 100;
    public int fuel = 100;
    public boolean inSpace = false;
    public Planet currentLocation;

    public Starship(Planet currentLocation){
        setCurrentLocation(currentLocation);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
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

    public void setCurrentLocation(Planet currentLocation) {
        this.currentLocation = currentLocation;
    }
}
