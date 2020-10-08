package com.games.pieces;

public class Starship {

    public static int health = 100;
    public static int fuel = 100;
    public boolean inSpace = false;
    public static Planet currentLocation;
    private static int Xpos = 1;
    private static int Ypos = 1;

    public Starship(Planet currentLocation){
        setCurrentLocation(currentLocation);
    }

    public static int getHealth() {
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

    public boolean isInSpace() {
        return inSpace;
    }

    public void setInSpace(boolean inSpace) {
        this.inSpace = inSpace;
    }

    public static Planet getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Planet location) {
        System.out.println("This is the set current location method- mwa ha ha");
        this.currentLocation = location;
        System.out.println(currentLocation.getName());
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
}
