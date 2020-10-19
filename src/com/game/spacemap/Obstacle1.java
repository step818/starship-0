package com.game.spacemap;

import java.awt.*;

public class Obstacle1 {
    int x;
    int y;
    int width;
    int height;

    int startX;
    //overall shape of the wall
    Rectangle hitBox;
    public Obstacle1(int x, int y, int width, int height){

        this.x = x;
        startX = x;
        this.y = y;
        this.width= width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.BLUE);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.LIGHT_GRAY);
        gtd.fillRect(x + 1, y + 1, width - 2, height - 2);
    }

    public int set(int cameraX){
        // move the walls and not the rocket
        x = startX + cameraX;
        hitBox.x = x;

        return x;
    }
}
