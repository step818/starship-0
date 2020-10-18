package com.games.pieces;

public class Alien {
    private int health = 100;
    private String position;
    private int x;
    private int y;

    public Alien(String position) {
        setPosition(position);
    }

    public Alien(String position, int x, int y) {
        setX(x);
        setY(y);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
