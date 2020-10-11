package com.games.pieces;

public class Alien {
    private int health = 100;
    private String position;

    public Alien(String position) {
        setPosition(position);
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

    // while alien health is > 0, continue to attack player
    // takes health from starship and player
    public void attack(){}

}
