package com.games.pieces;

import java.util.ArrayList;

public class Asteroid {
    public String size;
    public String position;

    public Asteroid(String size){
        setSize(size);
    }
    public Asteroid(String size, String position){
        this(size);
        setPosition(position);
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
}
