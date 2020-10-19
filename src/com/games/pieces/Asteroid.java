package com.games.pieces;

import java.util.ArrayList;

public class Asteroid {
    public String size;
    public String position;
    public int x, y;

    public Asteroid(String size){
        setSize(size);
    }
    public Asteroid(String size, String position){
        this(size);
        setPosition(position);
    }
    public Asteroid(String size, int x, int y) {
        this(size);
        setX(x);
        setY(y);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
