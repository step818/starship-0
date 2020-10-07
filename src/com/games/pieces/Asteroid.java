package com.games.pieces;

public class Asteroid {
    public String size;
    public String position;

    public Asteroid(String size, String position){
        setSize(size);
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

    // take health from starship
    public void collide(){
        if(size.equals("small")){
            // take least damage
        }
        else if(size.equals("medium")){
            // take more damage
        }
        else{
            // take most damage
        }
    }
}
